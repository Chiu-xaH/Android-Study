package com.example.lifedemo

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun CircleProgressCompose(progress: Int) {
    AndroidView(
        factory = { context ->
            CircleProgressView(context).apply {
                this.progress = progress
            }
        },
        update = { view ->
            view.progress = progress
        }
    )
}
