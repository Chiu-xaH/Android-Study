package com.xah.hotfix.sample.activity

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import com.xah.hotfix.sample.application.MyApplication
import com.xah.hotfix.sample.ui.GlobalUiHolder
import com.xah.hotfix.sample.ui.theme.HotFixTheme
import com.xah.uicommon.style.align.CenterScreen
import com.xah.uicommon.style.align.ColumnVertical
import dalvik.system.DexClassLoader
import java.io.File
import java.io.FileOutputStream

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HotFixTheme {
                CenterScreen {
                    ColumnVertical {
                        Text(GlobalUiHolder.text)
                        Button(
                            onClick = {
//                                applyPatch()
                            }
                        ) {
                            Text("热更新")
                        }
                    }
                }
            }
        }
    }
}

fun applyPatch() {
    try {
        println(GlobalUiHolder.text)
        val context = MyApplication.context

        // 1. 准备外部存储路径 (外部应用专属目录，不需要额外权限)
        val patchDir = File(context.getExternalFilesDir(null), "patch")
        if (!patchDir.exists()) patchDir.mkdirs()

        val patchFile = File(patchDir, "classes.dex")

        // 2. 拷贝补丁到外部目录
        context.assets.open("classes.dex").use { input ->
            FileOutputStream(patchFile).use { output ->
                input.copyTo(output)
            }
        }

        // 3. 设置只读权限 (Android 14 要求 dex 文件不可写)
        patchFile.setReadOnly()

        // 4. dex 优化目录必须在内部的 codeCacheDir 下
        val optimizedDir = File(context.codeCacheDir, "opt_dex")
        if (!optimizedDir.exists()) optimizedDir.mkdirs()

        // 5. 创建 DexClassLoader
        val patchClassLoader = DexClassLoader(
            patchFile.absolutePath,
            optimizedDir.absolutePath,
            null,
            context.classLoader
        )

        // 6. 注入到 App ClassLoader
        injectDexAtFirst(patchClassLoader, context.classLoader)
        println(GlobalUiHolder.text)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun injectDexAtFirst(patchClassLoader: ClassLoader, appClassLoader: ClassLoader) {
    val pathListField = Class.forName("dalvik.system.BaseDexClassLoader")
        .getDeclaredField("pathList").apply { isAccessible = true }

    val dexElementsField = Class.forName("dalvik.system.DexPathList")
        .getDeclaredField("dexElements").apply { isAccessible = true }

    // 获取两个 ClassLoader 的元素数组
    val patchPathList = pathListField.get(patchClassLoader)
    val patchDexElements = dexElementsField.get(patchPathList) as Array<*>

    val appPathList = pathListField.get(appClassLoader)
    val appDexElements = dexElementsField.get(appPathList) as Array<*>

    // 合并数组，补丁在前
    val newElements = java.lang.reflect.Array.newInstance(
        appDexElements::class.java.componentType,
        patchDexElements.size + appDexElements.size
    )

    System.arraycopy(patchDexElements, 0, newElements, 0, patchDexElements.size)
    System.arraycopy(appDexElements, 0, newElements, patchDexElements.size, appDexElements.size)

    // 替换回去
    dexElementsField.set(appPathList, newElements)
}


