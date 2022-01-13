package com.manijee.edtechspark.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.manijee.edtechspark.R;

public class LoginPage extends AppCompatActivity {
    EditText email, password;
    EditText e, p;
    PreferenceManager preferenceManager;
    Button Login;
    CheckBox checkBox;
    TextView Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        if (preferenceManager == null) {

        } else {

            Intent move = new Intent(LoginPage.this, SplashScreen.class);
            startActivity(move);

        }
        preferenceManager = PreferenceManager.getInstance(this);

        email = findViewById(R.id.edtName);

        e = email;

        password = findViewById(R.id.edtEmail);

        p = password;

        Login = findViewById(R.id.btnLogin);

        checkBox = findViewById(R.id.checkBox);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        Register = findViewById(R.id.Notregisteryet);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(LoginPage.this, com.manijee.edtechspark.views.activities.RegisterPage.class);
                startActivity(register);
            }
        });


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HandleLoginClick();
            }
        });
    }

    public void HandleLoginClick() {
        if (TextUtils.isEmpty(email.getText()) && TextUtils.isEmpty(password.getText())) {
            Toast.makeText(this, "Please enter id and password first", Toast.LENGTH_SHORT).show();
        } else {
            saveUserDetailsOnDevice();

        }

    }

    private void saveUserDetailsOnDevice() {
        String userId = preferenceManager.getInfo("userId");
        String userPassword = preferenceManager.getInfo("password");
        if (email.getText().toString().equals(userId) && password.getText().toString().equals(userPassword)) {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            Intent move = new Intent(LoginPage.this, SplashScreen.class);
            startActivity(move);
        } else {
            Toast.makeText(this, "Id password not matched", Toast.LENGTH_SHORT).show();
        }

    }



}