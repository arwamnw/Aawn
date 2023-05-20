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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterCgiver extends AppCompatActivity {
    EditText fullName_CG, email_CG, password_CG, repeatPassword_CG;
    CheckBox checkBox_Condition;
    Button CgBtn;
    final int minPasswordLength = 6;
    private TextView privacyCG;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_cgiver);

        fullName_CG = findViewById(R.id.et_first_name);
        email_CG = findViewById(R.id.et_email);
        password_CG = findViewById(R.id.et_password);
        repeatPassword_CG = findViewById(R.id.et_repeat_password);
        checkBox_Condition = findViewById(R.id.etcon);
        CgBtn = findViewById(R.id.cgbutton);
        privacyCG = findViewById(R.id.privacyCG);



        CgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                validatingInput();
                EmailValidation(email_CG.getText().toString());
                performSignUp(view);
            }
        });

        privacyCG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebPage(view);
            }

        });
    }



    void viewInitializations() {
        fullName_CG = findViewById(R.id.et_first_name);
        email_CG = findViewById(R.id.et_email);
        password_CG = findViewById(R.id.et_password);
        repeatPassword_CG = findViewById(R.id.et_repeat_password);
        checkBox_Condition = findViewById(R.id.etcon);


        // To show back button in actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // Checking if the input in form is valid
    boolean validatingInput() {
        // Checking that the user intered all the required field
        if (fullName_CG.getText().toString().equals("")) {
            fullName_CG.setError("الرجاء إدخال الاسم!");
            return false;
        }
        if (email_CG.getText().toString().equals("")) {
            email_CG.setError("الرجاء إدخال البريد الإلكتروني!");
            return false;
        }
        if (password_CG.getText().toString().equals("")) {
            password_CG.setError("الرجاء إدخال كلمة المرور!");
            return false;
        }
        if (repeatPassword_CG.getText().toString().equals("")) {
            repeatPassword_CG.setError("الرجاء إعادة إدخال كلمة المرور!");
            return false;
        }

        // Checking the email format
        if (!EmailValidation(email_CG.getText().toString())) {
            email_CG.setError("الرجاء كتابة البريد الإلكتروني بشكل صحيح!");
            return false;
        }

        // Checking password Length
        if (password_CG.getText().length() < minPasswordLength) {
            password_CG.setError("كلمة المرور يجب أن تكون أكثر من " + minPasswordLength + "خانات!");
            return false;
        }

        // Checking if Password and repeat password are the same
        if (!password_CG.getText().toString().equals(repeatPassword_CG.getText().toString())) {
            repeatPassword_CG.setError("كلمة المرور وإعادة كلمة المرور غير متطابقة!");
            return false;
        }
        // Checking that Conditions and rules chckbox is checked
        if (!checkBox_Condition.isChecked()){
            checkBox_Condition.setError("للمتابعة يجب الموافقة على الشروط والأحكام");
            return false;
        }
        return true;
    }

    // Email validation function
    boolean EmailValidation(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    // Hook Click Event
    public void performSignUp (View v) {
        if (validatingInput()) {

            // Input is valid, here send data to your server

            final String fullName = fullName_CG.getText().toString().trim();
            final String email = email_CG.getText().toString().trim();
            final String password = password_CG.getText().toString().trim();


            //Toast.makeText(this,"تسجيل الدخول تم بنجاح",Toast.LENGTH_SHORT).show();


            // Here you can call you API
            StringRequest stringRequest = new StringRequest(
                    Request.Method.POST,
                    AppConfig.URL_Register,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(
                                    getApplicationContext(),
                                    response.toString(),
                                    Toast.LENGTH_LONG
                            ).show();

                            if (response.equals("تم تسجيل مقدم الرعاية بنجاح")){

                                // go to next scene
                                startActivity(new Intent(RegisterCgiver.this, LoginCgiver.class));
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
                    params.put("email", email);
                    params.put("password", password);
                    return params;

                }

            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
            startActivity(new Intent(RegisterCgiver.this, LoginCgiver.class));






        }

    }

    public void loadWebPage(View view){
        Intent intent = new Intent(this, PrivacyPolicyActivity.class);
        startActivity(intent);

    }
}



