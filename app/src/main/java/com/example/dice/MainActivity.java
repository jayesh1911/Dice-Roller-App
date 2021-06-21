package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public ImageView showDice;
    public Random randomNum= new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDice = findViewById(R.id.imageView);
        showDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer song = MediaPlayer.create(getApplicationContext(),R.raw.click);
                song.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.reset();
                        mp.release();
                    }
                });
                song.start();
                rollDice();
            }
        });
    }
    public void rollDice(){
        int num = randomNum.nextInt(6)+1;
        switch (num){
            case 1:
                showDice.setImageResource(R.drawable.one);
                break;
            case 2:
                showDice.setImageResource(R.drawable.two);
                break;
            case 3:
                showDice.setImageResource(R.drawable.three);
                break;
            case 4:
                showDice.setImageResource(R.drawable.four);
                break;
            case 5:
                showDice.setImageResource(R.drawable.five);
                break;
            case 6:
                showDice.setImageResource(R.drawable.six);
                break;
        }
    }
}