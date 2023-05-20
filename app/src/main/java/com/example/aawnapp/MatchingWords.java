package com.example.aawnapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.snackbar.Snackbar;

public class MatchingWords extends AppCompatActivity {

    private CardView one;
    private CardView two;
    private CardView three;
    private CardView four;
    private CardView five;
    private CardView six;
    private CardView seven;
    private CardView eight;
    private ImageView arrowback;
    int child_id;
    String game_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_words);

        Intent i = getIntent();
        child_id=i.getIntExtra("child_id",0);
        game_type=i.getStringExtra("game_type");
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);

        arrowback = findViewById(R.id.arrowback);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MatchingWords.this, Phrase1.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type",game_type);
                i.putExtra("game_name","sentence one");
                startActivity(i);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MatchingWords.this, Phrase2.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type",game_type);
                i.putExtra("game_name","sentence two");
                startActivity(i);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MatchingWords.this, Phrase3.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type",game_type);
                i.putExtra("game_name","sentence three");
                startActivity(i);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MatchingWords.this, Phrase4.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type",game_type);
                i.putExtra("game_name","sentence four");
                startActivity(i);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MatchingWords.this, Phrase5.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type",game_type);
                i.putExtra("game_name","sentence five");
                startActivity(i);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MatchingWords.this, Phrase6.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type",game_type);
                i.putExtra("game_name","sentence six");
                startActivity(i);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MatchingWords.this, Phrase7.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type",game_type);
                i.putExtra("game_name","sentence seven");
                startActivity(i);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MatchingWords.this, Phrase8.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type",game_type);
                i.putExtra("game_name","sentence eight");
                startActivity(i);
            }
        });

        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MatchingWords.this, AllGames.class);
                i.putExtra("child_id",child_id);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });


    }
}