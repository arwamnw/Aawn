package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Phrase5Win extends AppCompatActivity {
    int child_id;
    String game_type;
    Button button;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase5_win);
        Intent i = getIntent();
        child_id = i.getIntExtra("child_id", 0);
        game_type = i.getStringExtra("game_type");
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Phrase5Win.this, Phrase6.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type",game_type);
                i.putExtra("game_name","sentence six");
                startActivity(i);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Phrase5Win.this, MatchingWords.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type",game_type);
                startActivity(i);
            }
        });
    }
}