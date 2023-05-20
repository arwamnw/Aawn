package com.example.aawnapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    /* Define the UI elements */
    private EditText eMail;
    private EditText ePassword;
    private Button eLogin;
    private TextView eRegister;
    final int minPasswordLength = 7;
    private TextView ChildForget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /* Bind the XML views to Java Code Elements */
        eMail = findViewById(R.id.ChildMail);
        ePassword = findViewById(R.id.ChildPassword);
        eLogin = findViewById(R.id.ChildbtnLogin);
        eRegister = findViewById(R.id.ChildRegister);
        ChildForget = findViewById(R.id.ChildForget);



        /* When the login button is clicked */
        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validatingInput();
                performLogin(view);
            }
        });

        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Allow the user in to your app by going into the Register activity */
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }

        });

        ChildForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Allow the user in to your app by going into the ForgetPass activity */
                startActivity(new Intent(LoginActivity.this, pass_forget.class));
            }

        });
    }

//============================ Methods ==================================================

    void viewInitializations() {

        eMail = findViewById(R.id.ChildMail);
        ePassword = findViewById(R.id.ChildPassword);
        eLogin = findViewById(R.id.ChildbtnLogin);
        eRegister = findViewById(R.id.ChildRegister);


        // To show back button in actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    boolean validatingInput() {

        // Checking that the user intered all the required field
        if (eMail.getText().toString().equals("")) {
            eMail.setError("الرجاء إدخال البريد الإلكتروني !");
            return false;
        }
        if (ePassword.getText().toString().equals("")) {
            ePassword.setError("الرجاء إدخال كلمة المرور !");
            return false;
        }
        // Checking the email format
        if (!EmailValidation(eMail.getText().toString())) {
            eMail.setError("الرجاء كتابة البريد الإلكتروني بشكل صحيح !");
            return false;
        }
        // Checking password Length
        if (ePassword.getText().length() < minPasswordLength) {
            ePassword.setError("كلمة المرور يجب أن تكون " + minPasswordLength + " خانات أو أكثر !");
            return false;
        }
        return true;
    }

    // Email validation function
    boolean EmailValidation(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    public void performLogin(View v) {

        if (validatingInput()) {

            // Input is valid, here send data to your server
            final String emailChild = eMail.getText().toString().trim();
            final String passwordChild = ePassword.getText().toString().trim();

            // Here you can call your API
            StringRequest stringRequest = new StringRequest(
                    Request.Method.POST,
                    AppConfig.URL_LOGIN_CHILD,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                           try{
                            JSONObject res=new JSONObject(response);
                            if (res.getBoolean("error")) {
                                Toast.makeText(getApplicationContext(),res.getString("msg"),Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(getApplicationContext(),res.getString("msg"),Toast.LENGTH_LONG).show();
                                Intent i = new Intent(LoginActivity.this, HomePageActivity.class);
                                i.putExtra("child_id",res.getInt("child_id") );
                                // go to next scene
                                startActivity(i);

                            }} catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(
                                    getApplicationContext(),
                                    error.getMessage(),
                                    Toast.LENGTH_LONG
                            ).show();

                        }
                    }

            ) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("email", emailChild);
                    params.put("password", passwordChild);
                    return params;


                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

    }
}