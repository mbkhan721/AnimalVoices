package com.example.animalvoices;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1, button2; // creating class variables
    MediaPlayer mpCows, mpPigs;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.btnCows);
        button2 = (Button) findViewById(R.id.btnPigs); // button controls instantiated
        button1.setOnClickListener(bCows);
        button2.setOnClickListener(bPigs);
        mpCows = new MediaPlayer();
        mpCows = MediaPlayer.create(this,R.raw.beyonce);
        mpPigs = new MediaPlayer();
        mpPigs = MediaPlayer.create(this, R.raw.waris);
        playing = 0;

        // changing action bar color
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#87CEEB"));
        actionBar.setBackgroundDrawable(colorDrawable);
    }
    Button.OnClickListener bCows = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    mpCows.start();
                    playing = 1;
                    button1.setText("Pause This Song");
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpCows.pause();
                    playing = 0;
                    button1.setText("Play Beyonce Song");
                    button2.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    Button.OnClickListener bPigs = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    mpPigs.start();
                    playing = 1;
                    button2.setText("Pause This Song");
                    button1.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpPigs.pause();
                    playing = 0;
                    button2.setText("Play Waris Baig Song");
                    button1.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}