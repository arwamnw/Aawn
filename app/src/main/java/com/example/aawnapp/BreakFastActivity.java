package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BreakFastActivity extends AppCompatActivity {

    private CardView cheeseCard;
    private TextView cheeseText;
    private ImageView cheeseView;

    private CardView eggCard;
    private TextView eggText;
    private ImageView eggView;

    private CardView pancakeCard;
    private TextView pancakeText;
    private ImageView pancakeView;

    private CardView cornflakesCard;
    private TextView cornflakesText;
    private ImageView cornflakesView;

    private CardView fruitsCard;
    private TextView fruitsText;
    private ImageView fruitsView;

    private CardView sandwichCard;
    private TextView sandwichText;
    private ImageView sandwichView;

    private ImageView arrowback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.breakfast_meals);

        cheeseCard = findViewById(R.id.cheeseCard);
        cheeseText = findViewById(R.id.cheeseText);
        cheeseView = findViewById(R.id.cheeseView);

        eggCard = findViewById(R.id.eggCard);
        eggText = findViewById(R.id.eggText);
        eggView = findViewById(R.id.eggView);

        pancakeCard = findViewById(R.id.pancakeCard);
        pancakeText = findViewById(R.id.pancakeText);
        pancakeView = findViewById(R.id.pancakeView);

        cornflakesCard = findViewById(R.id.cornflakesCard);
        cornflakesText = findViewById(R.id.cornflakesText);
        cornflakesView = findViewById(R.id.cornflakesView);

        fruitsCard = findViewById(R.id.fruitsCard);
        fruitsText = findViewById(R.id.fruitsText);
        fruitsView = findViewById(R.id.fruitsView);

        sandwichCard = findViewById(R.id.sandwichCard);
        sandwichText = findViewById(R.id.sandwichText);
        sandwichView = findViewById(R.id.sandwichView);

        arrowback = findViewById(R.id.arrowback);

        cheeseCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, CheeseActivity.class));
            }
        });
        cheeseText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, CheeseActivity.class));
            }
        });
        cheeseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, CheeseActivity.class));
            }
        });



        eggCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, EggActivity.class));
            }
        });
        eggText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, EggActivity.class));
            }
        });
        eggView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, EggActivity.class));
            }
        });


        pancakeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, PanCakeActivity.class));
            }
        });
        pancakeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, PanCakeActivity.class));
            }
        });
        pancakeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, PanCakeActivity.class));
            }
        });



        cornflakesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, CornFlakesActivity.class));
            }
        });
        cornflakesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, CornFlakesActivity.class));
            }
        });
        cornflakesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, CornFlakesActivity.class));
            }
        });


        fruitsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, FruitsActivity.class));
            }
        });
        fruitsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, FruitsActivity.class));
            }
        });

        fruitsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, FruitsActivity.class));
            }
        });


        sandwichCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, SandwichActivity.class));
            }
        });
        sandwichText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, SandwichActivity.class));
            }
        });
        sandwichView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, SandwichActivity.class));
            }
        });
        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BreakFastActivity.this, MealsActivity.class));
            }
        });
    }
}