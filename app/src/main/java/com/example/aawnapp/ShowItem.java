package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
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

public class ShowItem extends AppCompatActivity {
    Button addbtn;
    ConstraintLayout items_show;
    Toolbar toolbar;
    GridView listView;
    ArrayList<myItem> arrayList = new ArrayList<>();
    MyAdapterItem adapter;
    int album_id;
    String album_name;
    int child_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);
        toolbar=findViewById(R.id.toolbar);
        addbtn = findViewById(R.id.addbtn);
        items_show=findViewById(R.id.items_show);
        Intent i = getIntent();
        album_id = i.getIntExtra("album_id", 0);
        album_name=i.getStringExtra("album_name");
        child_id=i.getIntExtra("child_id",0);
        toolbar.setTitle("البومى-"+album_name);
        String msg=i.getStringExtra("msg");
        listView = findViewById(R.id.listView);

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Constants.SHOW_URL_ITEM + "?id=" + album_id+"&child_id="+child_id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject responseJson = new JSONObject(response);
                    Boolean error = responseJson.getBoolean("error");

                    if (error) {
                        Toast.makeText(getApplicationContext(), responseJson.getString("message"), Toast.LENGTH_LONG).show();
                    } else {
                        JSONArray jsonArray = responseJson.getJSONArray("message");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject responseJsonArr = new JSONObject(jsonArray.getString(i));
                            arrayList.add(new myItem(responseJsonArr.getInt("ID"), responseJsonArr.getString("item_name"), responseJsonArr.getString("item_photo"), responseJsonArr.getString("item_audio"),album_name));
                        }
                        adapter = new MyAdapterItem(getApplicationContext(), arrayList);
                        listView.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });


        // To prevent timeout error
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // Add the request to the RequestQueue.
        stringRequest.setShouldCache(false);
        queue.add(stringRequest);
        if (msg!=null){
            Snackbar.make(items_show,msg, Snackbar.LENGTH_LONG).show();
        }
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ShowItem.this, AddItem.class);
                i.putExtra("album_id",album_id);
                i.putExtra("album_name",album_name);
                i.putExtra("child_id",child_id);
                startActivity(i);
                finish();
            }
        });
    }
}