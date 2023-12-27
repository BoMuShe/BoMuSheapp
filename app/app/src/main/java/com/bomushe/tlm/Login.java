package com.bomushe.tlm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;


public class Login extends AppCompatActivity {
    private LinearLayout login;
    private LinearLayout forgot;
    private LinearLayout signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        forgot = findViewById(R.id.forgot);
        signup = findViewById(R.id.signup);
    }
    public void NoUserName(View view){
        login.setVisibility(View.GONE);
        forgot.setVisibility(View.GONE);
        signup.setVisibility(View.VISIBLE);
    }
    public void ForgotPassWrod(View view){
        login.setVisibility(View.GONE);
        forgot.setVisibility(View.VISIBLE);
        signup.setVisibility(View.GONE);
    }
    public void Login(View view){
        login.setVisibility(View.VISIBLE);
        forgot.setVisibility(View.GONE);
        signup.setVisibility(View.GONE);
    }
}