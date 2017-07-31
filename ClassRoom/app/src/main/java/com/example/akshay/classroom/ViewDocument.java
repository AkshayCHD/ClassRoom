package com.example.akshay.classroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class ViewDocument extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_document);
        Intent i=getIntent();
        UserInfo user=(UserInfo)i.getSerializableExtra("Object passed");
        Toast.makeText(this,user.getSubjectValues()+String.valueOf(user.getSemValues()),Toast.LENGTH_SHORT).show();
        WebView myWebView = (WebView) findViewById(R.id.myWebView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient()); // set the WebViewClient

        myWebView.loadUrl("https://drive.google.com/open?id=0B3XR0Z3DX_S1RU9tQTEzaEkzdWM");
    }
}
