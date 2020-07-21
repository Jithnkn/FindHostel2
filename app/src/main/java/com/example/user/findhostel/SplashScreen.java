package com.example.user.findhostel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    int timeout=3000;
    Timer timer=new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent i=new Intent(SplashScreen.this,MainActivity.class);
                startActivity(i);
            }
        },timeout);
    }
}
