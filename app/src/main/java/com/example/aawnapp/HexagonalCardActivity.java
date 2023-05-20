package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HexagonalCardActivity extends AppCompatActivity {

    private ImageView HexagonalRecording;
    private ImageView arrowback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.hexagonal);

        HexagonalRecording = findViewById(R.id.HexagonalRecording);
        arrowback = findViewById(R.id.arrowback);

        final MediaPlayer player = MediaPlayer.create(this, R.raw.hexagonal);
        HexagonalRecording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();

            }
        });

        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HexagonalCardActivity.this, ShapesActivity.class));
            }
        });
    }
}