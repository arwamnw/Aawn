package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ColorsActivity extends AppCompatActivity {

    private CardView blueCard;
    private ImageView blueView;
    private TextView blueText;

    private CardView redCard;
    private ImageView redView;
    private TextView redText;

    private CardView whiteCard;
    private ImageView whiteView;
    private TextView whiteText;

    private CardView greenCard;
    private ImageView greenView;
    private TextView greenText;

    private CardView blackCard;
    private ImageView blackView;
    private TextView blackText;

    private ImageView arrowback;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.allcolors);

        blueCard = findViewById(R.id.blueCard);
        blueView = findViewById(R.id.blueView);
        blueText = findViewById(R.id.blueText);

        redCard = findViewById(R.id.redCard);
        redView = findViewById(R.id.redView);
        redText = findViewById(R.id.redText);

        whiteCard = findViewById(R.id.whiteCard);
        whiteView = findViewById(R.id.whiteView);
        whiteText = findViewById(R.id.whiteText);


        greenCard = findViewById(R.id.greenCard);
        greenView = findViewById(R.id.greenView);
        greenText = findViewById(R.id.greenText);

        blackCard = findViewById(R.id.blackCard);
        blackView = findViewById(R.id.blackView);
        blackText = findViewById(R.id.blackText);

        arrowback = findViewById(R.id.arrowback);

        blueCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ColorsActivity.this, BlueActivity.class));
            }
        });
        blueView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ColorsActivity.this, BlueActivity.class));
            }
        });
        blueText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ColorsActivity.this, BlueActivity.class));
            }
        });



        redCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ColorsActivity.this, RedActivity.class));
            }
        });
        redView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ColorsActivity.this, RedActivity.class));
            }
        });
        redText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ColorsActivity.this, RedActivity.class));
            }
        });



        whiteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ColorsActivity.this, WhiteActivity.class));
            }
        });
        whiteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ColorsActivity.this, WhiteActivity.class));
            }
        });
        whiteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ColorsActivity.this, WhiteActivity.class));
            }
        });


        greenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ColorsActivity.this, GreenActivity.class));
            }
        });
        greenView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ColorsActivity.this, GreenActivity.class));
            }
        });
        greenText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ColorsActivity.this, GreenActivity.class));
            }
        });

        blackCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ColorsActivity.this, BlackActivity.class));
            }
        });
        blackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ColorsActivity.this, BlackActivity.class));
            }
        });
        blackText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ColorsActivity.this, BlackActivity.class));
            }
        });

        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ColorsActivity.this, AlbumsActivity.class));
            }
        });
    }
}