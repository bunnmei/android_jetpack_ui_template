package com.example.android_jetpack_ui_template.ui.components

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebView() {
    AndroidView(
        factory = {context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()

                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                settings.setSupportZoom(true)
            }

        },
        update = {webView ->
            webView.loadUrl("http://10.0.2.2:8080/articles")

        }
    )
}