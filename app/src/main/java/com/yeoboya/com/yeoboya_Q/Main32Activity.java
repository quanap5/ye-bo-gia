package com.yeoboya.com.yeoboya_Q;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class Main32Activity extends AppCompatActivity {
    //private String addressBar = "http://192.168.0.24/smmclab.jnu.ac.kr";
    private String addressBar = "http://yeoboya.com";

    private WebView webView;
    private Button buttonGo;
    private Button buttonStatic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main32);

        webView = (WebView) findViewById(R.id.webView);


        // Tùy biến WebViewClient để điều khiển các sự kiện trên WebView
        webView.setWebViewClient(new MyWebViewClient(addressBar));
        goUrl();

//        buttonGo.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                goUrl();
//            }
//        });

    }

    private void goUrl() {
        String url = addressBar;
        if (url.isEmpty()) {
            Toast.makeText(this, "Please enter url", Toast.LENGTH_SHORT).show();
            return;
        }
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        //webView.getSettings().setCacheMode(2);
        //webView.getSettings().setSupportMultipleWindows(true);
        //webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);


        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        webView.loadUrl(url);


    }

}