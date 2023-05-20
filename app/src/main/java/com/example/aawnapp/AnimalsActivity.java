package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalsActivity extends AppCompatActivity {

    private CardView dogCard;
    private ImageView dogView;
    private TextView dogText;


    private CardView catCard;
    private ImageView catView;
    private TextView catText;

    private CardView camelCard;
    private ImageView camelView;
    private TextView camelText;

    private CardView cowCard;
    private ImageView cowView;
    private TextView cowText;

    private ImageView arrowback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.allanimals);

        dogCard = findViewById(R.id.dogCard);
        dogView = findViewById(R.id.dogView);
        dogText = findViewById(R.id.dogText);

        catCard = findViewById(R.id.catCard);
        catView = findViewById(R.id.catView);
        catText = findViewById(R.id.catText);

        camelCard = findViewById(R.id.camelCard);
        camelView = findViewById(R.id.camelView);
        camelText = findViewById(R.id.camelText);

        cowCard = findViewById(R.id.cowCard);
        cowView = findViewById(R.id.cowView);
        cowText = findViewById(R.id.cowText);

        arrowback = findViewById(R.id.arrowback);


        dogCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AnimalsActivity.this, DogActivity.class));
            }
        });
        dogView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AnimalsActivity.this, DogActivity.class));
            }
        });
        dogText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AnimalsActivity.this, DogActivity.class));
            }
        });


        catCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AnimalsActivity.this, CatActivity.class));
            }
        });
        catView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AnimalsActivity.this, CatActivity.class));
            }
        });
        catText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AnimalsActivity.this, CatActivity.class));
            }
        });


        camelCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AnimalsActivity.this, CamelActivity.class));
            }
        });
        camelView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AnimalsActivity.this, CamelActivity.class));
            }
        });
        camelText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AnimalsActivity.this, CamelActivity.class));
            }
        });


        cowCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AnimalsActivity.this, CowActivity.class));
            }
        });
        cowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AnimalsActivity.this, CowActivity.class));
            }
        });
        cowText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AnimalsActivity.this, CowActivity.class));
            }
        });

        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AnimalsActivity.this, AlbumsActivity.class));
            }
        });
    }
}