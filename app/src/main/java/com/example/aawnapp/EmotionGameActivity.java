package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmotionGameActivity extends AppCompatActivity {

    int child_id;
    String game_type;
    private CardView happyFace;
    private CardView sadFace;
    private CardView angryFace;
    private CardView surprisedFace;
    private CardView fearFace;
    private CardView disgustedFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion_game);
        Intent i = getIntent();
        child_id = i.getIntExtra("child_id", 0);
        game_type = i.getStringExtra("game_type");
        happyFace = findViewById(R.id.happyFace);
        sadFace = findViewById(R.id.sadFace);
        angryFace = findViewById(R.id.angryFace);
        surprisedFace = findViewById(R.id.surprisedFace);
        fearFace = findViewById(R.id.fearFace);
        disgustedFace = findViewById(R.id.disgustedFace);

        happyFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EmotionGameActivity.this, HappyEmotionGame.class);
                i.putExtra("child_id", child_id);
                i.putExtra("game_type", game_type);
                i.putExtra("game_name", "Happy Emotion Game");
                startActivity(i);
            }
        });

        sadFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EmotionGameActivity.this, SadEmotionGame.class);
                i.putExtra("child_id", child_id);
                i.putExtra("game_type", game_type);
                i.putExtra("game_name", "Sad Emotion Game");
                startActivity(i);
            }
        });

        angryFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EmotionGameActivity.this, AngryEmotionGame.class);
                i.putExtra("child_id", child_id);
                i.putExtra("game_type", game_type);
                i.putExtra("game_name", "Sad Emotion Game");
                startActivity(i);

            }
        });

        surprisedFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EmotionGameActivity.this, SurprisedEmotionGame.class);
                i.putExtra("child_id", child_id);
                i.putExtra("game_type", game_type);
                i.putExtra("game_name", "Sad Emotion Game");
                startActivity(i);

            }
        });

        fearFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EmotionGameActivity.this, FearEmotionGame.class);
                i.putExtra("child_id", child_id);
                i.putExtra("game_type", game_type);
                i.putExtra("game_name", "Sad Emotion Game");
                startActivity(i);

            }
        });

        disgustedFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EmotionGameActivity.this, DisgustedEmotionGame.class);
                i.putExtra("child_id", child_id);
                i.putExtra("game_type", game_type);
                i.putExtra("game_name", "Sad Emotion Game");
                startActivity(i);

            }
        });
    }
}