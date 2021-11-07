package com.farooqkhan.learnersland.static_book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.farooqkhan.learnersland.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class Java extends AppCompatActivity {
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        pdfView =  findViewById(R.id.pdf5);
        pdfView.fromAsset("java.pdf")
                .defaultPage(0)
                .enableAnnotationRendering(true)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(2)
                .load();

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}