package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RiceActivity extends AppCompatActivity {

    private ImageView arrowback;
    private ImageView recording;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.rice_lunch);

        arrowback = findViewById(R.id.arrowback);
        recording = findViewById(R.id.recording);


        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(RiceActivity.this, LunchActivity.class));
            }
        });

        final MediaPlayer player = MediaPlayer.create(this, R.raw.rice);
        recording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();

            }
        });
    }
}