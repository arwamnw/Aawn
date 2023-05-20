package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AngryEmotion extends AppCompatActivity {

    private ImageView angryRecording;
    private ImageView arrowback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.angry_emotion);

        arrowback = findViewById(R.id.arrowback);
        angryRecording = findViewById(R.id.angryRecording);

        final MediaPlayer player = MediaPlayer.create(this, R.raw.angry);
        angryRecording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();

            }
        });

        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AngryEmotion.this, EmotionsActivity.class));
            }
        });
    }
}