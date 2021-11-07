package com.farooqkhan.learnersland.static_book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.farooqkhan.learnersland.databinding.ActivityStaticBook2Binding;

public class static_Book extends AppCompatActivity {
   ActivityStaticBook2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStaticBook2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Books");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.cpCpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(static_Book.this,cp_cpp.class);
                startActivity(intent);
            }
        });
        binding.cpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(static_Book.this,cpp.class);
                startActivity(intent);
            }
        });

        binding.dsaCpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(static_Book.this,dsaCpp.class);
                startActivity(intent);
            }
        });

        binding.java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(static_Book.this,Java.class);
                startActivity(intent);
            }
        });

        binding.cpPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(static_Book.this,cpPython.class);
                startActivity(intent);
            }
        });


        binding.dsaPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(static_Book.this, dsapython.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}