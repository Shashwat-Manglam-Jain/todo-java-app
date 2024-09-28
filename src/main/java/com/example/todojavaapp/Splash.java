package com.example.todojavaapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Create an Intent to start MainActivity
        final Intent intent = new Intent(Splash.this, MainActivity.class);

        // Use a Handler to delay starting the MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start MainActivity and finish the Splash activity
                startActivity(intent);
                finish();
            }
        }, 1000); // 1000 milliseconds delay
    }
}
