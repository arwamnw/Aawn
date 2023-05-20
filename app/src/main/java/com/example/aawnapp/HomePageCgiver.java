package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomePageCgiver extends AppCompatActivity {

    private TextView logoutViewCR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_cgiver);

        logoutViewCR = findViewById(R.id.logoutViewCR);

        logoutViewCR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                SharedPrefManager.getInstance(getApplicationContext()).logout();

            }
        });

    }
}