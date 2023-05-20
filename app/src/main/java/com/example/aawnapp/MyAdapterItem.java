package com.example.aawnapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class MyAdapterItem extends BaseAdapter {
    ProgressBar pbar;
    private Context context;
    private ArrayList<myItem> arrayList;
    private TextView name;
    private ImageView imageItem;
    private CardView Card;

    public MyAdapterItem(Context context, ArrayList<myItem> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        name = convertView.findViewById(R.id.name);
        imageItem = convertView.findViewById(R.id.imageItem);
        Card = convertView.findViewById(R.id.Card);
        name.setText(arrayList.get(position).getName());
        pbar = convertView.findViewById(R.id.progress_circular);
        pbar.setVisibility(View.GONE);
        new ImageLoaderClass(Constants.URL + arrayList.get(position).getImage(),imageItem,pbar).execute();
        Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context.getApplicationContext(), item.class);
                i.putExtra("item_id", arrayList.get(position).getId());
                i.putExtra("item_photo", arrayList.get(position).getImage());
                i.putExtra("item_audio", arrayList.get(position).getAudio());
                i.putExtra("item_name", arrayList.get(position).getName());
                i.putExtra("album_name", arrayList.get(position).getAlbum_name());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
        return convertView;
    }


}

