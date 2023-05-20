package com.example.aawnapp;

import static android.content.ContentValues.TAG;

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
import android.widget.Toolbar;

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


public class LoginCgiver extends AppCompatActivity {

    /* Define the UI elements */
    private EditText cgiverMail;
    private EditText cgiverPassword;
    private Button cgiverLogin;
    private TextView cgiverRegister;
    final int minPasswordLength = 7;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_cgiver);

        /* Bind the XML views to Java Code Elements */
        cgiverMail = findViewById(R.id.CgiverMail);
        cgiverPassword = findViewById(R.id.CgiverPassword);
        cgiverLogin = findViewById(R.id.CgiverbtnLogin);
        cgiverRegister = findViewById(R.id.CgiverRegister);




        /* when the login button is clicked */
        cgiverLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validatingInput();
                performLogin(view);

            }
        });

        cgiverRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Allow the user to go into the Register activity */
                startActivity(new Intent(LoginCgiver.this, RegisterCgiver.class));
            }

        });
    }


// ================================== Methods ======================================

    void viewInitializations() {
        cgiverMail = findViewById(R.id.CgiverMail);
        cgiverPassword = findViewById(R.id.CgiverPassword);
        cgiverLogin = findViewById(R.id.CgiverbtnLogin);
        cgiverRegister = findViewById(R.id.CgiverRegister);


        // To show back button in actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    boolean validatingInput() {
        // Checking that the user intered all the required field


        if (cgiverMail.getText().toString().equals("")) {
            cgiverMail.setError("الرجاء إدخال البريد الإلكتروني !");
            return false;
        }
        if (cgiverPassword.getText().toString().equals("")) {
            cgiverPassword.setError("الرجاء إدخال كلمة المرور !");
            return false;
        }

        // Checking the email format
        if (!EmailValidation(cgiverMail.getText().toString())) {
            cgiverMail.setError("الرجاء كتابة البريد الإلكتروني بشكل صحيح !");
            return false;
        }

        // Checking password Length
        if (cgiverPassword.getText().length() < minPasswordLength) {
            cgiverPassword.setError("كلمة المرور يجب أن تكون " + minPasswordLength + " خانات أو أكثر !");
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

            final String emailCg = cgiverMail.getText().toString().trim();
            final String passwordCg = cgiverPassword.getText().toString().trim();



            // Here you can call your API
            StringRequest stringRequest = new StringRequest(
                    Request.Method.POST,
                    AppConfig.URL_LOGIN,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(
                                    getApplicationContext(),
                                    response.toString(),
                                    Toast.LENGTH_LONG
                            ).show();

                            if (response.equals("تم تسجيل الدخول")){

                                // go to next scene
                                startActivity(new Intent(LoginCgiver.this, HomePageCgiver.class));
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

            ){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("email", emailCg);
                    params.put("password", passwordCg);
                    return params;


                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);







        }
    }

}