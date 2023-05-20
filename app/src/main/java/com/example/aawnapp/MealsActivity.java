package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MealsActivity extends AppCompatActivity {

    private CardView lunchCard;
    private ImageView lunchView;
    private TextView lunchText;

    private CardView breakfastCard;
    private ImageView breakfastView;
    private TextView breakfastText;

    private CardView dinnerCard;
    private ImageView dinnerView;
    private TextView dinnerText;

    private CardView snackCard;
    private ImageView snackView;
    private TextView snackText;

    private ImageView arrowback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        lunchCard = findViewById(R.id.lunchCard);
        lunchView = findViewById(R.id.lunchView);
        lunchText = findViewById(R.id.lunchText);

        breakfastCard = findViewById(R.id.breakfastCard);
        breakfastView = findViewById(R.id.breakfastView);
        breakfastText = findViewById(R.id.breakfastText);

        dinnerCard = findViewById(R.id.dinnerCard);
        dinnerView = findViewById(R.id.dinnerView);
        dinnerText = findViewById(R.id.dinnerText);

        snackCard = findViewById(R.id.snackCard);
        snackView = findViewById(R.id.snackView);
        snackText = findViewById(R.id.snackText);

        arrowback = findViewById(R.id.arrowback);

        lunchCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MealsActivity.this, LunchActivity.class));
            }
        });
        lunchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MealsActivity.this, LunchActivity.class));
            }
        });
        lunchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MealsActivity.this, LunchActivity.class));
            }
        });



        breakfastCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MealsActivity.this, BreakFastActivity.class));
            }
        });
        breakfastView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MealsActivity.this, BreakFastActivity.class));
            }
        });
        breakfastText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MealsActivity.this, BreakFastActivity.class));
            }
        });

        dinnerCard.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

                startActivity(new Intent(MealsActivity.this, DinnerActivity.class));
           }
        });
        dinnerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MealsActivity.this, DinnerActivity.class));
            }
        });
        dinnerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MealsActivity.this, DinnerActivity.class));
            }
        });


        snackCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MealsActivity.this, SnackActivity2.class));
            }
        });
        snackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MealsActivity.this, SnackActivity2.class));
            }
        });
        snackText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MealsActivity.this, SnackActivity2.class));
            }
        });
        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MealsActivity.this, HomePageActivity.class));
            }
        });


    }
}