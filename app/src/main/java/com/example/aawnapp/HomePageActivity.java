package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomePageActivity extends AppCompatActivity {


    private CardView emotionsCard;
    private CardView mealsCard;
    private CardView albumCard;
    private CardView gamesCard;
    private TextView setting;
    private TextView logoutView;
    private int child_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        emotionsCard = findViewById(R.id.EmotionCard);
        mealsCard = findViewById(R.id.mealsCard);
        albumCard = findViewById(R.id.albumCard);
        gamesCard = findViewById(R.id.gamesCard);
        setting = findViewById(R.id.setting);
        logoutView = findViewById(R.id.logoutViewCR);
        Intent i = getIntent();
        child_id = i.getIntExtra("child_id", 0);


        emotionsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomePageActivity.this, EmotionsActivity.class));
            }
        });


        mealsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomePageActivity.this, MealsActivity.class));
            }

        });


        albumCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePageActivity.this, AlbumsActivity.class);
                i.putExtra("child_id", child_id);
                startActivity(i);
            }

        });

        gamesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePageActivity.this, AllGames.class);
                i.putExtra("child_id", child_id);
                startActivity(i);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomePageActivity.this, SettingActivity.class));
            }
        });

        logoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                SharedPrefManager.getInstance(getApplicationContext()).logout();

            }
        });


    }
}
