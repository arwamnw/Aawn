package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

public class item extends AppCompatActivity {
    int id;
    String photo, audio, name, album_name;
    Toolbar tb;
    ImageView imageView;
    TextView info_text;
    CardView audioCard;
    ProgressBar pbar;
    ProgressBar pbar2;
    Bitmap Imagebitmap;
    Boolean isPLAYING = false;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        tb = findViewById(R.id.toolbar);
        imageView = findViewById(R.id.imageItem);
        info_text = findViewById(R.id.info_text);
        audioCard = findViewById(R.id.audio_card);
        Intent i = getIntent();
        id = i.getIntExtra("item_id", 0);
        photo = i.getStringExtra("item_photo");
        audio = i.getStringExtra("item_audio");
        name = i.getStringExtra("item_name");
        album_name = i.getStringExtra("album_name");
        tb.setTitle(album_name + "-" + name);
        info_text.setText(name);
        pbar = (ProgressBar) findViewById(R.id.progress_circular);
        pbar.setVisibility(View.GONE);
        pbar2 = (ProgressBar) findViewById(R.id.progress_circular2);
        pbar2.setVisibility(View.GONE);
        new ImageLoaderClass().execute(Constants.URL + photo);
        audioCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MyService.class);
                i.putExtra("audio",Constants.URL + audio);
                if (!isPLAYING) {
                    isPLAYING = true;
                    pbar2.setVisibility(View.VISIBLE);
                    startService(i);

                } else {
                    isPLAYING = false;
                    stopService(i);
                    pbar2.setVisibility(View.GONE);
                }
            }
        });

    }

    private class ImageLoaderClass extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pbar.setVisibility(View.VISIBLE);

        }

        protected Bitmap doInBackground(String... args) {
            try {
                Imagebitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return Imagebitmap;
        }

        protected void onPostExecute(Bitmap image) {

            if (image != null) {
                imageView.setImageBitmap(image);

                pbar.setVisibility(View.GONE);

            }
        }
    }
}

