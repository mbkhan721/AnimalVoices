package com.example.animalvoices;

import androidx.appcompat.app.AppCompatActivity;

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
        mpCows = MediaPlayer.create(this,R.raw.cows);
        mpPigs = new MediaPlayer();
        mpPigs = MediaPlayer.create(this, R.raw.pigs);
        playing = 0;
    }
    Button.OnClickListener bCows = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    mpCows.start();
                    playing = 1;
                    button1.setText("Pause Cows Sound");
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpCows.pause();
                    playing = 0;
                    button1.setText("Play Cows Sound");
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
                    button2.setText("Pause Pigs Sound");
                    button1.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpPigs.pause();
                    playing = 0;
                    button2.setText("Play Pigs Sound");
                    button1.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}