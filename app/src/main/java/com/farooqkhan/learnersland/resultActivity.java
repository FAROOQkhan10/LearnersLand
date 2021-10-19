package com.farooqkhan.learnersland;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.farooqkhan.learnersland.databinding.ActivityResultBinding;

public class resultActivity extends AppCompatActivity {
    ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        getSupportActionBar().setTitle("Result");
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int correctAns = getIntent().getIntExtra("correct",0);
        int totalQuestions = getIntent().getIntExtra("total",0);


        binding.score.setText(String.format("%d/%d",correctAns,totalQuestions));


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}