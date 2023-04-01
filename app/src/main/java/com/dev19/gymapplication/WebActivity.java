package com.dev19.gymapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_actitivty);
        webView=findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        //webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSclSmXyflmHGOK9ARW4iIX2zBw3A5M_HMHoM5Rkew8qMog9Jw/viewform?usp=sf_link");
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }
}