package com.example.myapplication.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.HashMap;
import java.util.Map;

public class MeSetting extends AppCompatActivity {
    private String db_url="";
    private String s = "/admin/index.html#/user/profile";
    private String t = "http://www.baidu.com";
    private String key;

    @Override
    protected void onCreate(Bundle e) {
        super.onCreate(e);
        setContentView(R.layout.token_webview);
        Intent intent = getIntent();
        key = intent.getStringExtra("key");
        db_url=intent.getStringExtra("url");
        s=db_url+s;

//        Map<String, String> map = new HashMap<String, String>();
//        map.put("Admin-Authorization", "bb5b64e9d55a462a91fa5ff23394d0e4");
        WebView mWebView = findViewById(R.id.webView2);

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mWebView.getSettings().setDefaultTextEncodingName("UTF-8");
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebView.getSettings().setBuiltInZoomControls(false);
        mWebView.getSettings().setSupportMultipleWindows(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setSupportZoom(false);
        mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setLoadsImagesAutomatically(true);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                HashMap<String, String> headerMap = new HashMap<>();
                //put all headers in this header map
                headerMap.put("Admin-Authorization", key);


                view.loadUrl(url, headerMap);
                return true;
            }
        });
        mWebView.loadUrl(s);

    }
}