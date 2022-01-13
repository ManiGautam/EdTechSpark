package com.manijee.edtechspark.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.manijee.edtechspark.R;

public class RegisterPage extends AppCompatActivity {
EditText email,password;
TextView Login;
PreferenceManager preferenceManager;
Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        preferenceManager = PreferenceManager.getInstance(this);

        email = findViewById(R.id.edtName);

        password = findViewById(R.id.edtEmail);

        Login = findViewById(R.id.Login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(RegisterPage.this,LoginPage.class);
                startActivity(login);
            }
        });

        Register = findViewById(R.id.btnRegister);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(email.getText().toString()) && TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(RegisterPage.this, "Id and Password field should not empty", Toast.LENGTH_SHORT).show();
                }else{
                    preferenceManager.setInfo("userId", email.getText().toString());
                    preferenceManager.setInfo("password", password.getText().toString());
                    Toast.makeText(RegisterPage.this, "You have registered successfully", Toast.LENGTH_SHORT).show();
                    email.setText("");
                    password.setText("");
                }
            }
        });
    }
}