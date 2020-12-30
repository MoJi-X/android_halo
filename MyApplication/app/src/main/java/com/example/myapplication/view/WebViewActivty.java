package com.example.myapplication.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.weicong.library.PWebView;

public class WebViewActivty extends AppCompatActivity {
    private String  s="http://www.baidu.com";
    @Override
    protected void onCreate(Bundle e){
        super.onCreate(e);
        setContentView(R.layout.webview_activity);
        final PWebView pWebView = (PWebView) findViewById(R.id.webView1);
        s=getIntent().getStringExtra("url");
        System.out.println(s);
        pWebView.loadUrl(s);
    }

}
