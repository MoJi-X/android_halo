package com.example.myapplication.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.weicong.library.PWebView;

import java.util.HashMap;
import java.util.Map;

public class WriteViewActivity extends AppCompatActivity {
    private String  s="http://47.113.204.48/admin/index.html#/posts/write";
    private String t="http://www.baidu.com";
    private String key;
    @Override
    protected void onCreate(Bundle e){
        super.onCreate(e);
        setContentView(R.layout.token_webview);
        Intent intent = getIntent();
        key=intent.getStringExtra("key");
        Map<String, String> map = new HashMap<String, String>();
        map.put("Admin-Authorization", "bb5b64e9d55a462a91fa5ff23394d0e4");
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
