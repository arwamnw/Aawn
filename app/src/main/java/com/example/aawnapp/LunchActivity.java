package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LunchActivity extends AppCompatActivity {

    private CardView riceCard;
    private TextView riceText;
    private ImageView riceView;

    private CardView fishCard;
    private TextView fishText;
    private ImageView fishView;

    private CardView chickenCard;
    private TextView chickenText;
    private ImageView chickenView;

    private CardView pastaCard;
    private TextView pastaText;
    private ImageView pastaView;

    private CardView friesCard;
    private TextView friesText;
    private ImageView friesView;

    private CardView friedChickenCard;
    private TextView friedChickenText;
    private ImageView friedChickenView;

    private ImageView arrowback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lunch_meals);

        riceCard = findViewById(R.id.riceCard);
        riceText = findViewById(R.id.riceText);
        riceView = findViewById(R.id.riceView);

        fishCard = findViewById(R.id.fishCard);
        fishText = findViewById(R.id.fishText);
        fishView = findViewById(R.id.fishView);

        chickenCard = findViewById(R.id.chickenCard);
        chickenText = findViewById(R.id.chickenText);
        chickenView = findViewById(R.id.chickenView);

        pastaCard = findViewById(R.id.pastaCard);
        pastaText = findViewById(R.id.pastaText);
        pastaView = findViewById(R.id.pastaView);

        friesCard = findViewById(R.id.friesCard);
        friesText = findViewById(R.id.friesText);
        friesView = findViewById(R.id.friesView);

        friedChickenCard = findViewById(R.id.friedChickenCard);
        friedChickenText = findViewById(R.id.friedChickenText);
        friedChickenView = findViewById(R.id.friedChickenView);

        arrowback = findViewById(R.id.arrowback);

        riceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, RiceActivity.class));
            }
        });
        riceText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, RiceActivity.class));
            }
        });
        riceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, RiceActivity.class));
            }
        });



        fishCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, FishActivity.class));
            }
        });
        fishText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, FishActivity.class));
            }
        });
        fishView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, FishActivity.class));
            }
        });



        chickenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, ChickenActivity.class));
            }
        });
        chickenText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, ChickenActivity.class));
            }
        });
        chickenView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, ChickenActivity.class));
            }
        });

        pastaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, PastaActivity.class));
            }
        });
        pastaText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, PastaActivity.class));
            }
        });
        pastaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, PastaActivity.class));
            }
        });



        friesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, FriesActivity.class));
            }
        });
        friesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, FriesActivity.class));
            }
        });
        friesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, FriesActivity.class));
            }
        });

        friedChickenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, FriedChickenActivity.class));
            }
        });
        friedChickenText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, FriedChickenActivity.class));
            }
        });
        friedChickenView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, FriedChickenActivity.class));
            }
        });
        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LunchActivity.this, MealsActivity.class));
            }
        });

    }
}