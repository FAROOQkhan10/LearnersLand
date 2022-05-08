package com.farooqkhan.learnersland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.sax.Element;
import android.view.View;
import android.widget.ImageView;

import com.farooqkhan.learnersland.databinding.ActivityAboutSectionBinding;

import java.util.Calendar;


public class About_Section extends AppCompatActivity {

   ImageView instagram , github,whatsapp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_section);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About");


        instagram = findViewById(R.id.instagram);
        whatsapp = findViewById(R.id.whatsapp);
        github = findViewById(R.id.github);

       instagram.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               gotourl("https://www.instagram.com/mohd.farooq4/");

           }
       });

       github.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               gotourl("https://github.com/FAROOQkhan10");
           }
       });



        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String wUrl = "https://wa.me/+916386160428?text=Hello ji";

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wUrl));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });



    }

    private void gotourl(String link) {
        Uri uri = Uri.parse(link);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }


}