package com.farooqkhan.learnersland;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpActivity extends AppCompatActivity {

    Button call_login,singUp_btn;
    ImageView image;
    TextView logoText;
    TextInputLayout fullName,username,password,Email;
    FirebaseFirestore database;
    FirebaseAuth auth;

    private Boolean Validate_full_name(){
        String val_full_name = fullName.getEditText().getText().toString();
        if(val_full_name.isEmpty()){
            fullName.setError("Field can't be empty");
            return false;
        }
        else{
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean ValidateUsername(){
        String val_username = username.getEditText().getText().toString();
        if(val_username.isEmpty()){
            username.setError("Field can't be empty");
            return false;
        }
        else{
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean Validate_email(){
        String val_email = Email.getEditText().getText().toString();
        if(val_email.isEmpty()){
            Email.setError("Field can't be empty");
            return false;
        }
        else{
            Email.setError(null);
            Email.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean Validate_password(){
        String val_password = password.getEditText().getText().toString();
        if(val_password.isEmpty()){
            password.setError("Field can't be empty");
            return false;
        }
        else{
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().hide();

        call_login=findViewById(R.id.sign_up_to_login_btn);
        singUp_btn=findViewById(R.id.sign_btn);
        image = findViewById(R.id.image1);
        logoText = findViewById(R.id.welcome);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        fullName=findViewById(R.id.name);
        Email=findViewById(R.id.email);


        call_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                Pair[] pairs = new Pair[8];
                pairs[0] = new Pair<View,String>(logoText,"logo_text");
                pairs[1] = new Pair<View,String>(image,"logo_image");
                pairs[2] = new Pair<View,String>(fullName,"full_name_trans");
                pairs[3] = new Pair<View,String>(username,"user_trans");
                pairs[4] = new Pair<View,String>(Email,"email_trans");
                pairs[5] = new Pair<View,String>(password,"password_trans");
                pairs[6] = new Pair<View,String>(singUp_btn,"sign_up_trans");
                pairs[7] = new Pair<View,String>(call_login,"already_trans");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(SignUpActivity.this,pairs);
                    startActivity(intent,options.toBundle());
                }
            }
        });

        singUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( !Validate_full_name() | !ValidateUsername() | !Validate_email() | !Validate_password()){
                    return;
                }

            }
        });



    }
}