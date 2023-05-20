package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText fullName_CH, age_CH, email_CH, password_CH, repeatPassword_CH;
    CheckBox Child_Condition;
    Button ChildBtn;
    final int MIN_PASSWORD_LENGTH = 7;
    private TextView privacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullName_CH = findViewById(R.id.childName);
        age_CH = findViewById(R.id.chaildAge);
        email_CH = findViewById(R.id.childEmail);
        password_CH = findViewById(R.id.childPassword);
        repeatPassword_CH = findViewById(R.id.ChildRePass);
        Child_Condition = findViewById(R.id.childCheckBox);
        ChildBtn = findViewById(R.id.SignChildButton);
        privacy = findViewById(R.id.privacyCG);

        ChildBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateInput();
                performSignUp(view);
         }

        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebPage(view);
            }

        });
    }

    void viewInitializations() {

        fullName_CH = findViewById(R.id.childName);
        age_CH = findViewById(R.id.chaildAge);
        email_CH = findViewById(R.id.childEmail);
        password_CH = findViewById(R.id.childPassword);
        repeatPassword_CH = findViewById(R.id.ChildRePass);
        Child_Condition = findViewById(R.id.childCheckBox);
        // To show back button in actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // Checking if the input in form is valid
    boolean validateInput() {
        if (fullName_CH.getText().toString().equals("")) {
            fullName_CH.setError("الرجاء إدخال الاسم!");
            return false;
        }
        if (age_CH.getText().toString().equals("")) {
            age_CH.setError("الرجاء ادخال العمر!");
            return false;
        }
        if (email_CH.getText().toString().equals("")) {
            email_CH.setError("الرجاء إدخال البريد الإلكتروني!");
            return false;
        }
        if (password_CH.getText().toString().equals("")) {
            password_CH.setError("الرجاء إدخال كلمة المرور!");
            return false;
        }
        if (repeatPassword_CH.getText().toString().equals("")) {
            repeatPassword_CH.setError("الرجاء إعادة إدخال كلمة المرور!");
            return false;
        }

        // checking the proper email format
        if (!isEmailValid(email_CH.getText().toString())) {
            email_CH.setError("الرجاء كتابة البريد الإلكتروني بشكل صحيح!");
            return false;
        }

        // checking minimum password Length
        if (password_CH.getText().length() < MIN_PASSWORD_LENGTH) {
            password_CH.setError("كلمة المرور يجب أن تكون أكثر من " + MIN_PASSWORD_LENGTH + "خانات!");
            return false;
        }

        // Checking if repeat password is same
        if (!password_CH.getText().toString().equals(repeatPassword_CH.getText().toString())) {
            repeatPassword_CH.setError("كلمة المرور وإعادة كلمة المرور غير متطابقة!");
            return false;
        }

        if (!Child_Condition.isChecked()){
            Child_Condition.setError("للمتابعة يجب الموافقة على الشروط والأحكام");
            return false;
        }
        return true;
    }

    boolean isEmailValid(String email) {

        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    // Hook Click Event
    public void performSignUp (View v) {
        if (validateInput()) {

            // Input is valid, send data to the server

           final String fullName = fullName_CH.getText().toString().trim();
           final String childAge = age_CH.getText().toString().trim();
           final String email = email_CH.getText().toString().trim();
           final String password = password_CH.getText().toString().trim();

            // Here we called the API
            StringRequest stringRequest = new StringRequest(
                    Request.Method.POST,
                    AppConfig.URL_Register_CHILD,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(
                                    getApplicationContext(),
                                    response.toString(),
                                    Toast.LENGTH_LONG
                            ).show();

                            if (response.equals("تم تسجيل الطفل/ة بنجاح")){

                                // go to next scene
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("name", fullName);
                    params.put("password", password);
                    params.put("email", email);
                    params.put("age", childAge);
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

        }
    }


    public void loadWebPage(View view){
        Intent intent = new Intent(this, PrivacyPolicyActivity.class);
        startActivity(intent);
    }
}

