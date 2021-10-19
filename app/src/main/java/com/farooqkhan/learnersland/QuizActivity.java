package com.farooqkhan.learnersland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.farooqkhan.learnersland.Model.Question;
import com.farooqkhan.learnersland.databinding.ActivityQuizBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    ActivityQuizBinding binding;
    ArrayList<Question> questions;
    int index=0;
    Question question;
    FirebaseFirestore database;
    int correctAnswers=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Question");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        questions=new ArrayList<>();
        database = FirebaseFirestore.getInstance();

        Random random = new Random();
        final int rand= random.nextInt(10);

        database.collection("questions")
                .whereGreaterThanOrEqualTo("index",rand)
                .orderBy("index")
                .limit(10).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                     if(queryDocumentSnapshots.getDocuments().size() <10){
                         for(DocumentSnapshot snapshot:queryDocumentSnapshots)
                         {
                             Question question= snapshot.toObject(Question.class);
                             questions.add(question);
                         }
                         setNextQuestion();
                     }

                     else
                     {
                         for(DocumentSnapshot snapshot:queryDocumentSnapshots)
                         {
                             Question question= snapshot.toObject(Question.class);
                             questions.add(question);
                         }
                         setNextQuestion();
                     }
            }
        });

        setNextQuestion();

    }

    void showAnswer()
    {
        if(question.getAns().equals(binding.option1.getText().toString()))
        {
            binding.option1.setBackground(getResources().getDrawable(R.drawable.option_right));
        }
        else if(question.getAns().equals(binding.option2.getText().toString()))
        {
            binding.option2.setBackground(getResources().getDrawable(R.drawable.option_right));
        }
        else if(question.getAns().equals(binding.option3.getText().toString()))
        {
            binding.option3.setBackground(getResources().getDrawable(R.drawable.option_right));
        }
        else if(question.getAns().equals(binding.option4.getText().toString()))
        {
            binding.option4.setBackground(getResources().getDrawable(R.drawable.option_right));
        }
    }

    void setNextQuestion()
    {
//        if( timer != null)
//             timer.cancel();
//        timer.start();
        if(index < questions.size())
        {   binding.questionCounter.setText(String.format("%d/%d",(index+1),questions.size()));
            question=questions.get(index);
            binding.question.setText(question.getQuestion());
            binding.option1.setText(question.getOpt1());
            binding.option2.setText(question.getOpt2());
            binding.option3.setText(question.getOpt3());
            binding.option4.setText(question.getOpt4());
        }
    }


    void checkAnswer(TextView textView)
    {    String  selectedAnswer=textView.getText().toString();
        if(selectedAnswer.equals(question.getAns()))
        {   correctAnswers++;
            textView.setBackground(getResources().getDrawable(R.drawable.option_right));
        }
        else
        {   showAnswer();
            textView.setBackground(getResources().getDrawable(R.drawable.option_wrong));
        }

    }

    void reset()
    {
        binding.option1.setBackground(getResources().getDrawable(R.drawable.option_unselecter));
        binding.option2.setBackground(getResources().getDrawable(R.drawable.option_unselecter));
        binding.option3.setBackground(getResources().getDrawable(R.drawable.option_unselecter));
        binding.option4.setBackground(getResources().getDrawable(R.drawable.option_unselecter));
    }


    public void onClick(View view)
    {
        switch (view.getId())
        {  case R.id.option_1:
            case R.id.option_2:
            case R.id.option_3:
            case R.id.option_4:
//                 if(timer!=null)
//                     timer.cancel();
                TextView selected =(TextView) view;
                checkAnswer(selected);
                break;
            case R.id.quitBtn:
                Intent intent = new Intent(QuizActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nextBtn:
                reset();
                if(index <= questions.size()) {
                    index++;
                    setNextQuestion();
                }
                else
                {
                    Intent intent1 = new Intent(QuizActivity.this,resultActivity.class);
                    intent1.putExtra("correct",correctAnswers);
                    intent1.putExtra("total",questions.size());
                    startActivity(intent1);

                    // Toast.makeText(this, "Quiz Finished.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }





}