package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BlackActivity extends AppCompatActivity {

    private ImageView blackRecording;
    private ImageView arrowback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.black);

        blackRecording = findViewById(R.id.blackRecording);
        arrowback = findViewById(R.id.arrowback);


        final MediaPlayer player = MediaPlayer.create(this, R.raw.black);
        blackRecording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();

            }
        });

        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BlackActivity.this, ColorsActivity.class));
            }
        });
    }
}