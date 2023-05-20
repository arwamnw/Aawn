package com.example.aawnapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

class ResetPassword  extends AppCompatActivity {
    EditText OTP_code, new_password, new_repeatPasword;
    final int MIN_PASSWORD_LENGTH = 7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_forget1);
        viewInitializations();
    }

    void viewInitializations() {
        OTP_code = findViewById(R.id.et_code);
        new_password = findViewById(R.id.et_password);
        new_repeatPasword = findViewById(R.id.et_repeat_password);

        // To show back button in actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // Checking if the input in form is valid
    boolean validateInput() {
        if (OTP_code.getText().toString().equals("")) {
            OTP_code.setError("الرجاء إدخال رمز OTP صحيح!");
            return false;
        }


        if (new_password.getText().toString().equals("")) {
            new_password.setError("الرجاء إدخال كلمة مرور جديدة!");
            return false;
        }
        if (new_repeatPasword.getText().toString().equals("")) {
            new_repeatPasword.setError("الرجاء إدخال إعادة كلمة المرور الجديدة!");
            return false;
        }

        // checking minimum password Length
        if (new_password.getText().length() < MIN_PASSWORD_LENGTH) {
            new_password.setError("Password Length must be more than " + MIN_PASSWORD_LENGTH + "characters");
            return false;
        }

        // Checking if repeat password is same
        if (!new_password.getText().toString().equals(new_repeatPasword.getText().toString())) {
            new_repeatPasword.setError("كلمة المرور وإعادة كلمة المرور ليست متوافقة");
            return false;
        }
        return true;
    }


    // Hook Click Event

    public void performResetPassword (View v) {
        if (validateInput()) {

            // Input is valid, here send data to server
            String OTP_code1 = OTP_code.getText().toString();
            String password = new_password.getText().toString();
            String repeatPassword = new_repeatPasword.getText().toString();

            Toast.makeText(this,"Password Reset Successfully",Toast.LENGTH_SHORT).show();
            // Calling API

        }
    }

}