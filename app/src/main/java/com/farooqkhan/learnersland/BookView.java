package com.farooqkhan.learnersland;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.farooqkhan.learnersland.databinding.ActivityBookViewBinding;

import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;

public class BookView<pubic> extends AppCompatActivity  implements DownloadFile.Listener{
    ActivityBookViewBinding binding;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Pdf View");
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("wait while loading...");
        progressDialog.show();

        String url = getIntent().getStringExtra("url");
        RemotePDFViewPager remotePDFViewPager =
                new RemotePDFViewPager(BookView.this, url, this);

       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    @Override
    public void onSuccess(String url, String destinationPath) {
        progressDialog.dismiss();
        PDFPagerAdapter adapter = new PDFPagerAdapter(this,extractFileNameFromUrl(url));
        binding.pdfViewPager.setAdapter(adapter);
    }

    public static String extractFileNameFromUrl(String url){
        return url.substring(url.lastIndexOf('/')+1);
    }

    @Override
    public void onFailure(Exception e) {

    }

    @Override
    public void onProgressUpdate(int progress, int total) {

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}