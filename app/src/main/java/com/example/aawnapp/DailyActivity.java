package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DailyActivity extends AppCompatActivity {

    private CardView brushTeethCard;
    private TextView brushTeethText;
    private ImageView brushTeethView;

    private CardView changeClothesCard;
    private TextView changeClothesText;
    private ImageView changeClothesView;

    private CardView bedMakingCard;
    private TextView bedMakingText;
    private ImageView bedMakingView;

    private CardView doHomeworkCard;
    private TextView doHomeworkText;
    private ImageView doHomeworkView;

    private ImageView arrowback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.alldaily);


        brushTeethCard = findViewById(R.id.brushTeethCard);
        brushTeethView = findViewById(R.id.brushTeethView);
        brushTeethText = findViewById(R.id.brushTeethText);

        changeClothesCard = findViewById(R.id.changeClothesCard);
        changeClothesView = findViewById(R.id.changeClothesView);
        changeClothesText = findViewById(R.id.changeClothesText);

        bedMakingCard = findViewById(R.id.bedMakingCard);
        bedMakingView = findViewById(R.id.bedMakingView);
        bedMakingText = findViewById(R.id.bedMakingText);

        doHomeworkCard = findViewById(R.id.doHomeworkCard);
        doHomeworkView = findViewById(R.id.doHomeworkView);
        doHomeworkText = findViewById(R.id.doHomeworkText);

        arrowback = findViewById(R.id.arrowback);

        brushTeethCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DailyActivity.this, BrushTeethActivity.class));
            }
        });
        brushTeethText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DailyActivity.this, BrushTeethActivity.class));
            }
        });
        brushTeethView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DailyActivity.this, BrushTeethActivity.class));
            }
        });



        changeClothesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DailyActivity.this, ChangeClothesActivity.class));
            }
        });
        changeClothesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DailyActivity.this, ChangeClothesActivity.class));
            }
        });
        changeClothesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DailyActivity.this, ChangeClothesActivity.class));
            }
        });



        bedMakingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DailyActivity.this, BedMakingActivity.class));
            }
        });
        bedMakingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DailyActivity.this, BedMakingActivity.class));
            }
        });
        bedMakingText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DailyActivity.this, BedMakingActivity.class));
            }
        });

        doHomeworkCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DailyActivity.this, DoHomeworkActivity.class));
            }
        });
        doHomeworkView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DailyActivity.this, DoHomeworkActivity.class));
            }
        });
        doHomeworkText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DailyActivity.this, DoHomeworkActivity.class));
            }
        });
        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DailyActivity.this, AlbumsActivity.class));
            }
        });
    }
}