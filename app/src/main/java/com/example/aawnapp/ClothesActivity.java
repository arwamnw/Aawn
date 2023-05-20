package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ClothesActivity extends AppCompatActivity {

    private CardView pantsCard;
    private ImageView pantsView;
    private TextView pantsText;

    private CardView shirtCard;
    private ImageView shirtView;
    private TextView shirtText;

    private CardView socksCard;
    private ImageView socksView;
    private TextView socksText;

    private CardView shoesCard;
    private ImageView shoesView;
    private TextView shoesText;

    private ImageView arrowback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.allclothes);

        pantsCard = findViewById(R.id.pantsCard);
        pantsView = findViewById(R.id.pantsView);
        pantsText = findViewById(R.id.pantsText);

        shirtCard = findViewById(R.id.shirtCard);
        shirtView = findViewById(R.id.shirtView);
        shirtText = findViewById(R.id.shirtText);

        socksCard = findViewById(R.id.socksCard);
        socksView = findViewById(R.id.socksView);
        socksText = findViewById(R.id.socksText);

        shoesCard = findViewById(R.id.shoesCard);
        shoesView = findViewById(R.id.shoesView);
        shoesText = findViewById(R.id.shoesText);

        arrowback = findViewById(R.id.arrowback);

        pantsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ClothesActivity.this, PantsActivity.class));
            }
        });
        pantsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ClothesActivity.this, PantsActivity.class));
            }
        });
        pantsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ClothesActivity.this, PantsActivity.class));
            }
        });



        shirtCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ClothesActivity.this, ShirtActivity.class));
            }
        });
        shirtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ClothesActivity.this, ShirtActivity.class));
            }
        });
        shirtText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ClothesActivity.this, ShirtActivity.class));
            }
        });



        socksCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ClothesActivity.this, SocksActivity.class));
            }
        });
        socksView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ClothesActivity.this, SocksActivity.class));
            }
        });
        socksText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ClothesActivity.this, SocksActivity.class));
            }
        });

        shoesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ClothesActivity.this, ShoesActivity.class));
            }
        });
        shoesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ClothesActivity.this, ShoesActivity.class));
            }
        });
        shoesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ClothesActivity.this, ShoesActivity.class));
            }
        });
        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ClothesActivity.this, AlbumsActivity.class));
            }
        });

    }
}