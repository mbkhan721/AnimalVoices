package com.example.animalvoices;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // changing action bar color
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#87CEEB"));
        actionBar.setBackgroundDrawable(colorDrawable);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish(); // releases the resource that was created for the splashActivity and closes the activity
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        };
        Timer opening = new Timer(); // Timer executes a one-time  task such as displaying an opening splash screen
        opening.schedule(task, 6000); // Pauses, or repeat actions for specified time
    }
}