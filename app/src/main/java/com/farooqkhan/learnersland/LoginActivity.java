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

public class LoginActivity extends AppCompatActivity {
    Button call_sign_up,login_btn;
    ImageView image;
    TextView logoText;
    TextInputLayout username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        call_sign_up = findViewById(R.id.login_to_sign_up_btn);
        image = findViewById(R.id.image1);
        logoText = findViewById(R.id.welcome);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_btn = findViewById(R.id.login_btn);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_user();
            }
        });
        call_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                Pair[] pairs = new Pair[6];
                pairs[0] = new Pair<View, String>(logoText, "logo_text");
                pairs[1] = new Pair<View, String>(image, "logo_image");
                pairs[2] = new Pair<View, String>(username, "user_trans");
                pairs[3] = new Pair<View, String>(password, "password_trans");
                pairs[4] = new Pair<View, String>(login_btn, "login_trans");
                pairs[5] = new Pair<View, String>(call_sign_up, "new_user_trans");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                    startActivity(intent, options.toBundle());
                }
            }
        });
    }
        private Boolean ValidateUsername(){
            String val = username.getEditText().getText().toString();
            if(val.isEmpty()){
                username.setError("Field can't be empty");
                return false;
            }
            else{
                username.setError(null);
                username.setErrorEnabled(false);
                return true;
            }
        }

        private Boolean validatePassword(){
            String val = password.getEditText().getText().toString();
            if(val.isEmpty()){
                password.setError("Field can't be empty");
                return false;
            }
            else{
                password.setError(null);
                password.setErrorEnabled(false);
                return true;
            }
        }

        public Boolean login_user(){
            if( !validatePassword() | !ValidateUsername()){
                return false;
            }
            else{
//                check_user();
                return true;
            }
    }












}