package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EmotionsActivity extends AppCompatActivity {

    private ImageView angry;
    private CardView cardAngry;
    private TextView textAngry;
    private ImageView happy;
    private CardView cardHappy;
    private TextView textHappy;
    private ImageView sad;
    private CardView cardSad;
    private TextView textSad;
    private ImageView afraid;
    private CardView cardAfraid;
    private TextView textAfraid;
    private ImageView embarrassed;
    private CardView cardEmbarrassed;
    private TextView textEmbarrassed;
    private ImageView surprised;
    private CardView cardSurprised;
    private TextView textSurprised;
    private ImageView arrowback;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotions);


        angry = findViewById(R.id.angryView);
        cardAngry = findViewById(R.id.cardAngry);
        textAngry = findViewById(R.id.textAngry);
        happy = findViewById(R.id.happyView);
        cardHappy = findViewById(R.id.cardHappy);
        textHappy = findViewById(R.id.textHappy);
        sad = findViewById(R.id.sadView);
        cardSad = findViewById(R.id.cardSad);
        textSad = findViewById(R.id.textSad);
        afraid = findViewById(R.id.afraidView);
        cardAfraid = findViewById(R.id.cardAfraid);
        textAfraid =findViewById(R.id.textAfraid);
        embarrassed = findViewById(R.id.embarrassedView);
        cardEmbarrassed =findViewById(R.id.cardEmbarrassed);
        textEmbarrassed =findViewById(R.id.textEmbarrassed);
        surprised = findViewById(R.id.surprisedView);
        cardSurprised = findViewById(R.id.cardSurprised);
        textSurprised = findViewById(R.id.textSurprised);
        arrowback = findViewById(R.id.arrowback);


        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, AngryEmotion.class));
            }
        });
        cardAngry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, AngryEmotion.class));
            }
        });
        textAngry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, AngryEmotion.class));
            }
        });


        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, HappyEmotion2.class));
            }
        });
        cardHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, HappyEmotion2.class));
            }
        });
        textHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, HappyEmotion2.class));
            }
        });


        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, SadEmotion.class));
            }
        });
        cardSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, SadEmotion.class));
            }
        });
        textSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, SadEmotion.class));
            }
        });


        afraid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, AfraidEmotion.class));
            }
        });
        cardAfraid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, AfraidEmotion.class));
            }
        });
        textAfraid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, AfraidEmotion.class));
            }
        });

        embarrassed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, EmbarrassedEmotion.class));
            }
        });
        cardEmbarrassed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, EmbarrassedEmotion.class));
            }
        });
        textEmbarrassed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, EmbarrassedEmotion.class));
            }
        });

        surprised.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, SurprisedEmotion2.class));
            }
        });
        cardSurprised.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, SurprisedEmotion2.class));
            }
        });
        textSurprised.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, SurprisedEmotion2.class));
            }
        });

        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(EmotionsActivity.this, HomePageActivity.class));
            }
        });

    }
}