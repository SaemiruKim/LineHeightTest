package net.meshkorea.android.lineheighttest

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_web_view.*
import java.io.BufferedReader
import java.io.FileReader
import java.io.InputStreamReader

class WebViewActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        with(webView.settings) {
            javaScriptEnabled = true
            loadWithOverviewMode = true
            cacheMode = WebSettings.LOAD_NO_CACHE
        }

        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = WebViewClient()

        val reader = FileReader(assets.open("baemin.js"))
        var contents = reader.rea

        // webView.loadUrl("https://www.naver.com/")
        webView.loadUrl("javascript:eval($contents)")
    }
}
