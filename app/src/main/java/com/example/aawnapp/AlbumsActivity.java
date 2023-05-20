package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity {

    GridView listView;
    ArrayList<myAlbum> arrayList = new ArrayList<>();
    MyAdapterAlbum adapter;
    private CardView shapesCard;
    private ImageView shapesView;
    private TextView shapesText;
    private CardView colorsCard;
    private ImageView colorsView;
    private TextView colorsText;
    private CardView animalsCard;
    private ImageView animalsView;
    private TextView animalsText;
    private CardView clothesCard;
    private ImageView clothesView;
    private TextView clothesText;
    private ImageView dailyView;
    private CardView dailyCard;
    private TextView dailyText;
    private Button addbtn;
    private ImageView arrowback;


    int child_id;
    private ConstraintLayout albums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        albums=findViewById(R.id.albums);
        shapesCard = findViewById(R.id.shapesCard);
        shapesView = findViewById(R.id.shapesView);
        shapesText = findViewById(R.id.shapesText);
        colorsCard = findViewById(R.id.colorsCard);
        colorsView = findViewById(R.id.colorsView);
        colorsText = findViewById(R.id.colorsText);
        animalsCard = findViewById(R.id.animalsCard);
        animalsView = findViewById(R.id.animalsView);
        animalsText = findViewById(R.id.animalsText);
        clothesCard = findViewById(R.id.clothesCard);
        clothesView = findViewById(R.id.clothesView);
        clothesText = findViewById(R.id.clothesText);
        dailyView = findViewById(R.id.dailyView);
        dailyCard = findViewById(R.id.dailyCard);
        dailyText = findViewById(R.id.dailyText);
        arrowback = findViewById(R.id.arrowback);
        addbtn = findViewById(R.id.addbtn);
        listView = findViewById(R.id.listView);
        Intent i = getIntent();
        String msg=i.getStringExtra("msg");
        child_id=i.getIntExtra("child_id",0);
        if (msg!=null){
            Snackbar.make(albums,msg, Snackbar.LENGTH_LONG).show();
        }
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Constants.IMAGES_URL+ "?child_id=" + child_id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject responseJson = new JSONObject(response);
                    Boolean error = responseJson.getBoolean("error");

                    if (error) {
                        Snackbar.make(albums, responseJson.getString("message"), Snackbar.LENGTH_LONG).show();
                    } else {
                        JSONArray jsonArray = responseJson.getJSONArray("message");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject responseJsonArr = new JSONObject(jsonArray.getString(i));
                            arrayList.add(new myAlbum(responseJsonArr.getInt("ID"), responseJsonArr.getString("album_name"), responseJsonArr.getString("album_photo"),child_id));
                        }
                        adapter = new MyAdapterAlbum(getApplicationContext(), arrayList);
                        listView.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    Snackbar.make(albums, e.getMessage(), Snackbar.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar.make(albums, error.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
            }
        });


        // To prevent timeout error
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // Add the request to the RequestQueue.
        stringRequest.setShouldCache(false);
        queue.add(stringRequest);
        shapesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AlbumsActivity.this, ShapesActivity.class));
            }
        });
        shapesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AlbumsActivity.this, ShapesActivity.class));
            }
        });
        shapesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AlbumsActivity.this, ShapesActivity.class));
            }
        });


        colorsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AlbumsActivity.this, ColorsActivity.class));
            }
        });
        colorsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AlbumsActivity.this, ColorsActivity.class));
            }
        });
        colorsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AlbumsActivity.this, ColorsActivity.class));
            }
        });


        animalsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AlbumsActivity.this, AnimalsActivity.class));
            }
        });
        animalsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AlbumsActivity.this, AnimalsActivity.class));
            }
        });
        animalsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AlbumsActivity.this, AnimalsActivity.class));
            }
        });


        clothesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AlbumsActivity.this, ClothesActivity.class));
            }
        });
        clothesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AlbumsActivity.this, ClothesActivity.class));
            }
        });
        clothesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AlbumsActivity.this, ClothesActivity.class));
            }
        });

        dailyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AlbumsActivity.this, DailyActivity.class));
            }
        });
        dailyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AlbumsActivity.this, DailyActivity.class));
            }
        });
        dailyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AlbumsActivity.this, DailyActivity.class));
            }
        });

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AlbumsActivity.this, CustomAdd.class);
                i.putExtra("child_id",child_id);
                startActivity(i);
                finish();
            }
        });
    }
}