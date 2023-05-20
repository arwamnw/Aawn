package com.example.aawnapp;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.View.DragShadowBuilder;
import android.widget.Button;
import android.widget.LinearLayout;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.volley.AuthFailureError;
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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class Phrase3 extends Activity implements OnTouchListener, OnDragListener {

    private static final String LOGCAT = null;
    TextView firstWord;
    TextView secondWord, thirdWord;
    Button btn;
    LinearLayout first, second, third;
    String RIGTH_WORD_1 = "تشاهد";
    String RIGTH_WORD_2 = "سارة";
    String RIGTH_WORD_3 = "التلفاز";
    int child_id;
    String game_type;
    String game_name;
    private RelativeLayout phrase;

    public static void upload(Context context, RelativeLayout phrase, String game_name, String game_type, String game_date, String game_result, int child_id) {
        RequestQueue queue = Volley.newRequestQueue(context);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.UPLOAD_GAME, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject responseJson = new JSONObject(response);
                    Boolean error = responseJson.getBoolean("error");
                    if (error) {
                        Snackbar.make(phrase, responseJson.getString("message"), Snackbar.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    Snackbar.make(phrase, e.getMessage(), Snackbar.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar.make(phrase, error.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("child_id", String.valueOf(child_id));
                params.put("game_name", game_name);
                params.put("game_type", game_type);
                params.put("game_result", game_result);
                params.put("game_date", game_date);
                return params;
            }
        };


        // To prevent timeout error
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // Add the request to the RequestQueue.
        stringRequest.setShouldCache(false);
        queue.add(stringRequest);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase3);
        phrase = findViewById(R.id.center);
        Intent i = getIntent();
        child_id = i.getIntExtra("child_id", 0);
        game_type = i.getStringExtra("game_type");
        game_name = i.getStringExtra("game_name");
        firstWord = findViewById(R.id.watch);
        findViewById(R.id.watch).setOnTouchListener(this);
        findViewById(R.id.layout1).setOnDragListener(this);
        findViewById(R.id.cv1).setOnDragListener(this);
        secondWord = findViewById(R.id.sara);
        findViewById(R.id.sara).setOnTouchListener(this);
        findViewById(R.id.layout3).setOnDragListener(this);
        findViewById(R.id.cv2).setOnDragListener(this);
        thirdWord = findViewById(R.id.tv);
        findViewById(R.id.tv).setOnTouchListener(this);
        findViewById(R.id.layout5).setOnDragListener(this);
        findViewById(R.id.cv3).setOnDragListener(this);

        first = (LinearLayout) findViewById(R.id.cv1);
        second = (LinearLayout) findViewById(R.id.cv2);
        third = (LinearLayout) findViewById(R.id.cv3);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> result = checkAnswer();
                if (!result.get("game_result").equals("-1" )) {
                    upload(getApplicationContext(), phrase, game_name, game_type, result.get("game_date"), result.get("game_result"), child_id);
                }

            }
        });

    }

    public Map<String, String> checkAnswer() {
        Map<String, String> result = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = dateFormat.format(calendar.getTime());
        result.put("game_date", date);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            result.put("game_date", String.valueOf(LocalDate.now()));
//        }
        try {
            // first word from player
            String firstWord = ((TextView) first.getChildAt(0)).getText().toString();
            // second word from player
            String secWord = ((TextView) second.getChildAt(0)).getText().toString();
            //third
            String thirdWord = ((TextView) third.getChildAt(0)).getText().toString();
            //Comparing each word with the right word
            if (RIGTH_WORD_1.equals(firstWord)) {
                if (RIGTH_WORD_2.equals(secWord)) {
                    if (RIGTH_WORD_3.equals(thirdWord)) {
                        result.put("game_result", String.valueOf(1));
                        Intent i=new Intent(Phrase3.this, Phrase3Win.class);
                        i.putExtra("child_id",child_id);
                        i.putExtra("game_type",game_type);
                        startActivity(i);
                    } else {
                        result.put("game_result", String.valueOf(0));
                        Intent i=new Intent(Phrase3.this, Phrase3Fail.class);
                        i.putExtra("child_id",child_id);
                        i.putExtra("game_type",game_type);
                        i.putExtra("game_name",game_name);
                        startActivity(i);
                    }
                } else {
                    result.put("game_result", String.valueOf(0));
                    Intent i=new Intent(Phrase3.this, Phrase3Fail.class);
                    i.putExtra("child_id",child_id);
                    i.putExtra("game_type",game_type);
                    i.putExtra("game_name",game_name);
                    startActivity(i);
                }
            } else {
                result.put("game_result", String.valueOf(0));
                Intent i=new Intent(Phrase3.this, Phrase3Fail.class);
                i.putExtra("child_id",child_id);
                i.putExtra("game_type",game_type);
                i.putExtra("game_name",game_name);
                startActivity(i);
            }
        } catch (NullPointerException e) {
            result.put("game_result", "-1");
            Snackbar.make(phrase, e.getMessage(), Snackbar.LENGTH_LONG).show();
        }
        return result;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            DragShadowBuilder shadowBuilder = new DragShadowBuilder(view);
            view.startDrag(null, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            return true;
        } else {
            return false;
        }
    }

    public boolean onDrag(View layoutview, DragEvent dragevent) {
        int action = dragevent.getAction();
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                Log.d(LOGCAT, "Drag event started");
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d(LOGCAT, "Drag event entered into " + layoutview.toString());
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                Log.d(LOGCAT, "Drag event exited from " + layoutview.toString());
                break;
            case DragEvent.ACTION_DROP:
                Log.d(LOGCAT, "Dropped");
                View view = (View) dragevent.getLocalState();
                ViewGroup owner = (ViewGroup) view.getParent();
                owner.removeView(view);
                LinearLayout container = (LinearLayout) layoutview;
                container.addView(view);
                view.setVisibility(View.VISIBLE);
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                Log.d(LOGCAT, "Drag ended");
                break;
            default:
                break;
        }
        return true;
    }
}