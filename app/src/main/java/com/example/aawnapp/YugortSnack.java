package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class YugortSnack extends AppCompatActivity {

    private ImageView arrowback;
    private ImageView recording;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.yugort_snack);

        arrowback = findViewById(R.id.arrowback);
        recording = findViewById(R.id.recording);

        final MediaPlayer player = MediaPlayer.create(this, R.raw.yogurt);
        recording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();

            }
        });

        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(YugortSnack.this, SnackActivity2.class));
            }
        });
    }
}