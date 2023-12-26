package com.bomushe.tlm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //定时跳转
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Bottom_nav.class);
                startActivity(intent);
                Intent intents = new Intent(MainActivity.this, Login.class);
                startActivity(intents);
                finish(); //界面销毁
            }
        },3000);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}