package com.example.learningportalapp

import android.graphics.Bitmap
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var portalWebView: WebView
    lateinit var etAddressBar: EditText
    lateinit var loadingBar: ProgressBar

    val defaultUrl = "https://www.google.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        portalWebView = findViewById(R.id.portalWebView)
        etAddressBar = findViewById(R.id.etAddressBar)
        loadingBar = findViewById(R.id.loadingBar)

        portalWebView.settings.javaScriptEnabled = true
        portalWebView.settings.domStorageEnabled = true

        portalWebView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                loadingBar.visibility = ProgressBar.VISIBLE
                etAddressBar.setText(url)
            }

            override fun onPageFinished(view: WebView, url: String) {
                loadingBar.visibility = ProgressBar.GONE
                etAddressBar.setText(url)
            }

            override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
                if (request.isForMainFrame) {
                    view.loadUrl("file:///android_asset/offline.html")
                }
            }
        }

        portalWebView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                loadingBar.progress = newProgress
            }
        }

        portalWebView.loadUrl(defaultUrl)

        findViewById<Button>(R.id.btnNavBack).setOnClickListener {
            if (portalWebView.canGoBack()) {
                portalWebView.goBack()
            } else {
                Toast.makeText(this, "No more history", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.btnNavForward).setOnClickListener {
            if (portalWebView.canGoForward()) {
                portalWebView.goForward()
            }
        }

        findViewById<Button>(R.id.btnNavRefresh).setOnClickListener {
            portalWebView.reload()
        }

        findViewById<Button>(R.id.btnNavHome).setOnClickListener {
            portalWebView.loadUrl(defaultUrl)
        }

        findViewById<Button>(R.id.btnGo).setOnClickListener {
            navigateToUrl()
        }

        etAddressBar.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)) {
                navigateToUrl()
                true
            } else {
                false
            }
        }

        findViewById<Button>(R.id.btnShortcutGoogle).setOnClickListener {
            portalWebView.loadUrl("https://www.google.com")
        }

        findViewById<Button>(R.id.btnShortcutYouTube).setOnClickListener {
            portalWebView.loadUrl("https://www.youtube.com")
        }

        findViewById<Button>(R.id.btnShortcutWikipedia).setOnClickListener {
            portalWebView.loadUrl("https://www.wikipedia.org")
        }

        findViewById<Button>(R.id.btnShortcutKhanAcademy).setOnClickListener {
            portalWebView.loadUrl("https://www.khanacademy.org")
        }

        findViewById<Button>(R.id.btnShortcutUniversity).setOnClickListener {
            portalWebView.loadUrl("https://www.aiub.edu")
        }
    }

    fun navigateToUrl() {
        var url = etAddressBar.text.toString().trim()
        if (url.isEmpty()) return
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://$url"
        }
        portalWebView.loadUrl(url)
    }

    override fun onBackPressed() {
        if (portalWebView.canGoBack()) {
            portalWebView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
