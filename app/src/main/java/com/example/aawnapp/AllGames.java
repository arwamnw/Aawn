package com.example.aawnapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AllGames extends AppCompatActivity {

    private Button EmotionRecognition;
    private Button speechRecognition;
    private Button WordsMatching;
    private ImageView arrowback;
    int child_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_games);

        EmotionRecognition = findViewById(R.id.EmotionRecognition);
        speechRecognition = findViewById(R.id.speechRecognition);
        WordsMatching = findViewById(R.id.WordsMatching);
        arrowback = findViewById(R.id.arrowback);
        Intent i = getIntent();
        child_id=i.getIntExtra("child_id",0);


        EmotionRecognition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AllGames.this, EmotionGameActivity.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type","Emotion Recognition");
                startActivity(i);
            }
        });

        speechRecognition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AllGames.this, WordGameActivity.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type","Speech Recognition");
                startActivity(i);
            }
        });

        WordsMatching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AllGames.this, MatchingWords.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type","Words Matching");
                startActivity(i);
            }
        });

        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AllGames.this, HomePageActivity.class);
                i.putExtra("child_id",child_id);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });
    }
}