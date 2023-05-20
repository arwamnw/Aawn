package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SnackActivity2 extends AppCompatActivity {

    private CardView yogurtCard;
    private ImageView yogurtView;
    private TextView yogurtText;

    private CardView muffinCard;
    private ImageView muffinView;
    private TextView muffinText;

    private CardView nutsCard;
    private ImageView nutsView;
    private TextView nutsText;

    private CardView bananaCard;
    private ImageView bananaView;
    private TextView bananaText;

    private ImageView arrowback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.snack_meals);

        yogurtCard = findViewById(R.id.yogurtCard);
        yogurtView = findViewById(R.id.yogurtView);
        yogurtText = findViewById(R.id.yogurtText);

        muffinCard = findViewById(R.id.muffinCard);
        muffinView = findViewById(R.id.muffinView);
        muffinText = findViewById(R.id.muffinText);

        nutsCard = findViewById(R.id.nutsCard);
        nutsView = findViewById(R.id.nutsView);
        nutsText = findViewById(R.id.nutsText);

        bananaCard = findViewById(R.id.bananaCard);
        bananaView = findViewById(R.id.bananaView);
        bananaText = findViewById(R.id.bananaText);

        arrowback = findViewById(R.id.arrowback);

        yogurtCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SnackActivity2.this, YugortSnack.class));
            }
        });
        yogurtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SnackActivity2.this, YugortSnack.class));
            }
        });
        yogurtText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SnackActivity2.this, YugortSnack.class));
            }
        });



        muffinCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SnackActivity2.this, MuffinActivity.class));
            }
        });
        muffinView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SnackActivity2.this, MuffinActivity.class));
            }
        });
        muffinText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SnackActivity2.this, MuffinActivity.class));
            }
        });



        nutsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SnackActivity2.this, NutsActivity.class));
            }
        });
        nutsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SnackActivity2.this, NutsActivity.class));
            }
        });
        nutsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SnackActivity2.this, NutsActivity.class));
            }
        });

        bananaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SnackActivity2.this, BananaActivity.class));
            }
        });
        bananaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SnackActivity2.this, BananaActivity.class));
            }
        });
        bananaText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SnackActivity2.this, BananaActivity.class));
            }
        });
        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SnackActivity2.this, MealsActivity.class));
            }
        });
    }
}