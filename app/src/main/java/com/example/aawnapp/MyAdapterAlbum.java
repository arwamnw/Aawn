package com.example.aawnapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

public class MyAdapterAlbum extends BaseAdapter {
    private Context context;
    private ArrayList<myAlbum> arrayList;
    private TextView name;
    private ImageView imageAlbum;
    private CardView Card;
    ProgressBar pbar;
    public MyAdapterAlbum(Context context, ArrayList<myAlbum> arrayList) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        name = convertView.findViewById(R.id.name);
        imageAlbum = convertView.findViewById(R.id.imageAlbum);
        Card=convertView.findViewById(R.id.Card);
        name.setText(arrayList.get(position).getName());
        pbar = convertView.findViewById(R.id.progress_circular);
        pbar.setVisibility(View.GONE);
        new ImageLoaderClass(Constants.URL+arrayList.get(position).getImage(),imageAlbum,pbar).execute();
        Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, ShowItem.class);
                i.putExtra("album_id",arrayList.get(position).getId());
                i.putExtra("album_name",arrayList.get(position).getName());
                i.putExtra("child_id",arrayList.get(position).getChild_id());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
        return convertView;
    }

}

