package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BlueActivity extends AppCompatActivity {

    private ImageView blueRecording;
    private ImageView arrowback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.blue);

        arrowback = findViewById(R.id.arrowback);
        blueRecording = findViewById(R.id.blueRecording);

        final MediaPlayer player = MediaPlayer.create(this, R.raw.blue);
        blueRecording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();

            }
        });

        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BlueActivity.this, ColorsActivity.class));
            }
        });
    }
}