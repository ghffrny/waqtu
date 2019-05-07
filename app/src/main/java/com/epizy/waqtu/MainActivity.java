package com.epizy.waqtu;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView; //inisialisasi webView sebagai WebView
    WebSettings webSettings; // inisialisasi webSettings sebagai WebSettings

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // membuat content view activity_main

        // identifikasi id webView
        webView = (WebView)findViewById(R.id.webView); 

        // mengatur webView sebagai web view client
        webView.setWebViewClient(new myWebclient()); 
        webSettings = webView.getSettings()

        // load url web client
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://waqtu.000webhostapp.com/"); 
    }

    //class myWebClient berguna untuk menampilkan proses pada website
    public class myWebclient extends WebViewClient{
        //url selesai
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url); //jika url berhasil di load maka akan menampilkannya
        }

        // url dimulai
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon); // ketika memulai halaman maka akan meload favicon website tersebut
        }

        //url proses
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url); // menampilkan progres loading ketika halaman dimuat
        }
    }

    // membuat event tombol kembali
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode== KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack(); // kembali kehalaman sebelumnya
            return true; // nilainya benar Ture
        }

        return super.onKeyDown(keyCode, event); // ketika tombol back di klik, maka tidak akan langsung keluar dari aplikasi, melainkan kembali kehalaman sebelumnya pada website
    }
}
