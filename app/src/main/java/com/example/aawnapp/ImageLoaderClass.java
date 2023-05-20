package com.example.aawnapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.net.URL;

public class ImageLoaderClass extends AsyncTask<String, String, Bitmap> {
    private String url;
    private ImageView imageView;
    private ProgressBar pbar;
    Bitmap Imagebitmap;

    public ImageLoaderClass(String url, ImageView imageView, ProgressBar pbar) {
        this.url = url;
        this.imageView = imageView;
        this.pbar=pbar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pbar.setVisibility(View.VISIBLE);

    }
    protected Bitmap doInBackground(String... args) {

        try {
            URL Connection = new URL(url);
            Imagebitmap = Bitmap.createBitmap(BitmapFactory.decodeStream(Connection.openStream()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Imagebitmap;
    }

    protected void onPostExecute(Bitmap image) {

        if(image != null){
            imageView.setImageBitmap(image);

            pbar.setVisibility(View.GONE);

        }
    }
}
