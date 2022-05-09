package com.farooqkhan.learnersland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

//import com.farooqkhan.learnersland.databinding.ActivityStaticBook2Binding;

public class Static_Book extends AppCompatActivity {

    ImageView cpCpp,cpp,dsaCpp,java,cpPython,dsaPython;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_book);

        getSupportActionBar().setTitle("Books");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        cpCpp = findViewById(R.id.cpCpp);
        cpp = findViewById(R.id.cpp);
        dsaCpp = findViewById(R.id.dsaCpp);
        java = findViewById(R.id.java);
        dsaPython = findViewById(R.id.dsa_python);
        cpPython = findViewById(R.id.cpPython);




        cpCpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://firebasestorage.googleapis.com/v0/b/learner-s-land.appspot.com/o/book.pdf?alt=media&token=0b94c570-09d9-4672-8039-03501bc8d1fa");
            }
        });

        cpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gotourl("https://firebasestorage.googleapis.com/v0/b/learner-s-land.appspot.com/o/C%2B%2B%20Primer.pdf?alt=media&token=c707158d-4a8c-4fc6-bda3-4ea25748b95c");

            }
        });

        dsaCpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://firebasestorage.googleapis.com/v0/b/learner-s-land.appspot.com/o/DS_Karumanchi.pdf?alt=media&token=6fc3bd64-4010-4980-be74-780d7bb1353a");
            }
        });

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://firebasestorage.googleapis.com/v0/b/learner-s-land.appspot.com/o/Head_First_Java_Second_Edition.pdf?alt=media&token=7edd2fcc-0b71-49ab-988f-0d5a0b636b07");

            }
        });

        cpPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://firebasestorage.googleapis.com/v0/b/learner-s-land.appspot.com/o/competitive-programming-in-python-128-algorithms-to-develop-your-coding-skills-1nbsped-9781108716826-1108716822_compress.pdf?alt=media&token=22fb44f3-b51b-46de-a836-5f42ee41ef57");

            }
        });


        dsaPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://firebasestorage.googleapis.com/v0/b/learner-s-land.appspot.com/o/Data_Structures_and_Algorithms_with_Python_en.pdf?alt=media&token=2db50dc8-c58f-40d2-9cc6-db81b8510d6d");

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