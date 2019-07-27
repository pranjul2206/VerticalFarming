package com.example.verticalfarming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CityGreensUniversity extends AppCompatActivity {
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_greens_university);
        web=findViewById(R.id.citygreensuniversityWebView);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("https://citygreens.in/cguniversity/");
    }

    @Override
    public void onBackPressed() {
        if(web.canGoBack()){
            web.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
