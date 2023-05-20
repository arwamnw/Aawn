package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HappyEmotion2 extends AppCompatActivity {

    private ImageView happyRecording;
    private ImageView arrowback;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.happy_emotion);


        happyRecording = findViewById(R.id.happyRecording);
        arrowback = findViewById(R.id.arrowback);


        final MediaPlayer player = MediaPlayer.create(this, R.raw.happy);
        happyRecording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();

            }
        });

        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HappyEmotion2.this, EmotionsActivity.class));
            }
        });
    }
}