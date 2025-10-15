package com.example.lifedemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CircleProgressView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    // 进度（0~100）
    var progress: Int = 0
        set(value) {
            field = value.coerceIn(0, 100)
            invalidate() // 进度改变，重绘
        }

    // 画笔
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        style = Paint.Style.STROKE
        strokeWidth = 20f
    }

    // 1️⃣ 测量阶段（可选自定义）
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val minSize = 200
        val width = resolveSize(minSize, widthMeasureSpec)
        val height = resolveSize(minSize, heightMeasureSpec)
        setMeasuredDimension(width, height)
    }

    // 3️⃣ 绘制阶段
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val radius = (width.coerceAtMost(height) / 2f) - paint.strokeWidth
        val cx = width / 2f
        val cy = height / 2f

        // 画背景圆
        paint.color = Color.LTGRAY
        canvas.drawCircle(cx, cy, radius, paint)

        // 画进度圆弧
        paint.color = Color.BLUE
        val rectF = RectF(
            cx - radius, cy - radius,
            cx + radius, cy + radius
        )
        canvas.drawArc(rectF, -90f, progress * 3.6f, false, paint)
    }
}
