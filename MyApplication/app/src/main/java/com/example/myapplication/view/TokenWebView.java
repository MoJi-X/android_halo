package com.example.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;

import com.weicong.library.PWebView;

import java.util.Map;

public class TokenWebView extends PWebView {


    public TokenWebView(Context context) {
        super(context);
    }

    public TokenWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void loadUrl(String url, Map<String, String> additionalHttpHeaders){
        throw new RuntimeException("Stub!");
    }
}
