package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EggActivity extends AppCompatActivity {

    private ImageView arrowback;
    private ImageView recording;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.egg_breakfast);

        arrowback = findViewById(R.id.arrowback);
        recording = findViewById(R.id.recording);


        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EggActivity.this, BreakFastActivity.class));
            }
        });

        final MediaPlayer player = MediaPlayer.create(this, R.raw.egg);
        recording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();

            }
        });
    }
}