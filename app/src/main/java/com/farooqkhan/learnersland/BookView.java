package com.farooqkhan.learnersland;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class BookView extends AppCompatActivity {
   WebView webView;
   ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_view);
//        String Url = getIntent().getStringExtra("url");

        String Url = "http://englishonlineclub.com/pdf/Data%20Structures%20and%20Algorithms%20in%20Python%20[EnglishOnlineClub.com].pdf";
//        https://www.rcsdk12.org/cms/lib/NY01001156/Centricity/Domain/4951/Head_First_Java_Second_Edition.pdf
//        https://cses.fi/book/book.pdf
//        http://englishonlineclub.com/pdf/Data%20Structures%20and%20Algorithms%20in%20Python%20[EnglishOnlineClub.com].pdf


        webView = findViewById(R.id.web_id);
//        progressBar = findViewById(R.id.progress_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setJavaScriptEnabled(true);
        String pdf_url= "https://docs.google.com/gview?embedded=true&url="+Url;
        webView.loadUrl(pdf_url);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}