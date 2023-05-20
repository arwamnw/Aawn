package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WordGameActivity extends AppCompatActivity {

    private CardView AppleWord;
    private CardView bagWord;
    private CardView chairWord;
    private CardView roseWord;
    private CardView tissueWord;
    private CardView waterWord;
    int child_id;
    String game_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_game);
        Intent i = getIntent();
        child_id=i.getIntExtra("child_id",0);
        game_type=i.getStringExtra("game_type");
        AppleWord = findViewById(R.id.AppleWord);
        bagWord = findViewById(R.id.bagWord);
        chairWord = findViewById(R.id.chairWord);
        roseWord = findViewById(R.id.roseWord);
        tissueWord = findViewById(R.id.tissueWord);
        waterWord = findViewById(R.id.waterWord);

        AppleWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(WordGameActivity.this, AppleWordGame.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type",game_type);
                i.putExtra("game_name","sentence one");startActivity(i);
            }
        });

        bagWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(WordGameActivity.this, BagWordGame.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type",game_type);
                i.putExtra("game_name","Bag Word Game");
                startActivity(i);
            }
        });

        chairWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(WordGameActivity.this, ChairWord.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type",game_type);
                i.putExtra("game_name","Chair Word");
                startActivity(i);
            }
        });

        roseWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(WordGameActivity.this, RoseWord.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type",game_type);
                i.putExtra("game_name","Rose Word");
                startActivity(i);
            }
        });

        tissueWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(WordGameActivity.this, TissueWord.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type",game_type);
                i.putExtra("game_name","Tissue Word");
                startActivity(i);
            }
        });

        waterWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(WordGameActivity.this, WaterWord.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type",game_type);
                i.putExtra("game_name","Water Word");
                startActivity(i);
            }
        });

    }
}