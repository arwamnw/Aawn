package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShapesActivity extends AppCompatActivity {

    private CardView triangleCard;
    private ImageView triangleView;
    private TextView triangleText;

    private CardView starCard;
    private ImageView starView;
    private TextView starText;

    private CardView hexagonalCard;
    private ImageView hexagonalView;
    private TextView hexagonalText;

    private CardView heartCard;
    private ImageView heartView;
    private TextView heartText;

    private CardView squareCard;
    private ImageView squareView;
    private TextView squareText;

    private ImageView arrowback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.allshapes);

        triangleCard = findViewById(R.id.triangleCard);
        triangleView = findViewById(R.id.triangleView);
        triangleText = findViewById(R.id.triangleText);

        starCard = findViewById(R.id.starCard);
        starView = findViewById(R.id.starView);
        starText = findViewById(R.id.starText);

        hexagonalCard = findViewById(R.id.hexagonalCard);
        hexagonalView = findViewById(R.id.hexagonalView);
        hexagonalText = findViewById(R.id.hexagonalText);

        heartCard = findViewById(R.id.heartCard);
        heartView = findViewById(R.id.heartView);
        heartText = findViewById(R.id.heartText);

        squareCard = findViewById(R.id.squareCard);
        squareView = findViewById(R.id.squareView);
        squareText = findViewById(R.id.squareText);

        arrowback = findViewById(R.id.arrowback);


        triangleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ShapesActivity.this, TriangleActivity.class));
            }
        });
        triangleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ShapesActivity.this, TriangleActivity.class));
            }
        });
        triangleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ShapesActivity.this, TriangleActivity.class));
            }
        });



        starCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ShapesActivity.this, StarActivity.class));
            }
        });
        starView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ShapesActivity.this, StarActivity.class));
            }
        });
        starText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ShapesActivity.this, StarActivity.class));
            }
        });

        hexagonalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ShapesActivity.this, HexagonalCardActivity.class));
            }
        });
        hexagonalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ShapesActivity.this, HexagonalCardActivity.class));
            }
        });
        hexagonalText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ShapesActivity.this, HexagonalCardActivity.class));
            }
        });

        heartCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ShapesActivity.this, HeartActivity.class));
            }
        });
        heartView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ShapesActivity.this, HeartActivity.class));
            }
        });
        heartText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ShapesActivity.this, HeartActivity.class));
            }
        });


        squareCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ShapesActivity.this, SquareActivity.class));
            }
        });
        squareView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ShapesActivity.this, SquareActivity.class));
            }
        });
        squareText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ShapesActivity.this, SquareActivity.class));
            }
        });

        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ShapesActivity.this, AlbumsActivity.class));
            }
        });
    }
}