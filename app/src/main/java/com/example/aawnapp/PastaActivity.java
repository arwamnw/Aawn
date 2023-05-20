package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PastaActivity extends AppCompatActivity {

    private ImageView arrowback;
    private ImageView recording;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pasta_lunch);

        arrowback = findViewById(R.id.arrowback);
        recording = findViewById(R.id.recording);



        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(PastaActivity.this, LunchActivity.class));
            }
        });

        final MediaPlayer player = MediaPlayer.create(this, R.raw.pasta);
        recording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();

            }
        });
    }
}