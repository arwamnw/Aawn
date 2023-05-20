package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DinnerActivity extends AppCompatActivity {

    private CardView yogurt_card;
    private ImageView yogurt_view;
    private TextView yogurt_text;

    private CardView viges_card;
    private ImageView viges_view;
    private TextView viges_text;

    private CardView salad_card;
    private ImageView salad_view;
    private TextView salad_text;

    private CardView egg_card;
    private ImageView egg_view;
    private TextView egg_text;

    private CardView fruits_card;
    private ImageView fruits_view;
    private TextView fruits_text;

    private CardView sandwich_card;
    private ImageView sandwich_view;
    private TextView sandwich_text;

    private ImageView arrowback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dinner_meals);

        yogurt_card = findViewById(R.id.yogurt_card);
        yogurt_view = findViewById(R.id.yogurt_view);
        yogurt_text = findViewById(R.id.yogurt_text);

        viges_card = findViewById(R.id.viges_card);
        viges_view = findViewById(R.id.viges_view);
        viges_text = findViewById(R.id.viges_text);

        salad_card = findViewById(R.id.salad_card);
        salad_view = findViewById(R.id.salad_view);
        salad_text = findViewById(R.id.salad_text);

        egg_card = findViewById(R.id.egg_card);
        egg_view = findViewById(R.id.egg_view);
        egg_text = findViewById(R.id.egg_text);

        fruits_card = findViewById(R.id.fruits_card);
        fruits_view = findViewById(R.id.fruits_view);
        fruits_text = findViewById(R.id.fruits_text);

        sandwich_card = findViewById(R.id.sandwich_card);
        sandwich_view = findViewById(R.id.sandwich_view);
        sandwich_text = findViewById(R.id.sandwich_text);

        arrowback = findViewById(R.id.arrowback);


        yogurt_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, YogurtActivity.class));
            }
        });
        yogurt_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, YogurtActivity.class));
            }
        });
        yogurt_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, YogurtActivity.class));
            }
        });



        viges_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, VigesActivity.class));
            }
        });
        viges_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, VigesActivity.class));
            }
        });
        viges_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, VigesActivity.class));
            }
        });

        salad_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, SaladActivity.class));
            }
        });
        salad_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, SaladActivity.class));
            }
        });
        salad_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, SaladActivity.class));
            }
        });



        egg_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, EggDinner.class));
            }
        });
        egg_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, EggDinner.class));
            }
        });
        egg_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, EggDinner.class));
            }
        });



        fruits_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, FruitsDinner.class));
            }
        });
        fruits_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, FruitsDinner.class));
            }
        });
        fruits_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, FruitsDinner.class));
            }
        });



        sandwich_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, SandwitchDinner.class));
            }
        });
        sandwich_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, SandwitchDinner.class));
            }
        });
        sandwich_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, SandwitchDinner.class));
            }
        });
        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DinnerActivity.this, MealsActivity.class));
            }
        });

    }
}