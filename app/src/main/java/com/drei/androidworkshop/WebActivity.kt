package com.drei.androidworkshop

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val webview = findViewById<WebView>(R.id.webview)

        webview.settings.javaScriptEnabled = true

        webview.webChromeClient = WebChromeClient()
        webview.webViewClient = object : WebViewClient() {

        }

        //webview.loadUrl("https://www.google.com/")
        webview.loadUrl("https://www.worldometers.info/coronavirus/")
    }
}