package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CowActivity extends AppCompatActivity {

    private ImageView CowRecording;
    private ImageView arrowback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.cow);

        CowRecording = findViewById(R.id.CowRecording);
        arrowback = findViewById(R.id.arrowback);

        final MediaPlayer player = MediaPlayer.create(this, R.raw.cow);
        CowRecording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();

            }
        });

        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(CowActivity.this, AnimalsActivity.class));
            }
        });
    }
}