package com.example.activitytest

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import com.example.activitytest.BaseActivity
import com.example.activitytest.R

class ThirdActivity : BaseActivity(){

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        webView = findViewById(R.id.webView)
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.loadUrl("file:///android_asset/index.html")
    }
}