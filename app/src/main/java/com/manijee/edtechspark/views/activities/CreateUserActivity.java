package com.manijee.edtechspark.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.manijee.edtechspark.R;
import com.manijee.edtechspark.model.CommonResponse;
import com.manijee.edtechspark.model.CreateUserRequestModel;
import com.manijee.edtechspark.repository.ApiManager;
import com.manijee.edtechspark.repository.CreateUserListener;
import com.manijee.edtechspark.views.presenters.CreateUserPresenter;

public class CreateUserActivity extends AppCompatActivity implements CreateUserListener {
    ProgressBar progressBar;
EditText email,password,confirm_pass,contact,name;
TextView Login;
PreferenceManager preferenceManager;
Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createuser);

        preferenceManager = PreferenceManager.getInstance(this);

        email = findViewById(R.id.edtName);

        password = findViewById(R.id.edtEmail);
        confirm_pass=findViewById(R.id.edtConfirmPassword);
        name = findViewById(R.id.edtName);
        contact = findViewById(R.id.edtContact);
progressBar = findViewById(R.id.progressBar);

        Register = findViewById(R.id.btnRegister);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(email.getText().toString()) &&
                        TextUtils.isEmpty(password.getText().toString())&&
                        TextUtils.isEmpty(confirm_pass.getText().toString())&&
                        TextUtils.isEmpty(contact.getText().toString())&&
                        TextUtils.isEmpty(name.getText().toString())
                ) {
                    Toast.makeText(CreateUserActivity.this, "Id and Password field should not empty", Toast.LENGTH_SHORT).show();
                }else if(confirm_pass.getText().toString().equals(password.getText().toString())){
                    Toast.makeText(CreateUserActivity.this, "Password and Confirm password does not match", Toast.LENGTH_SHORT).show();
                    confirm_pass.setText("");
                }else{
                    progressBar.setVisibility(View.VISIBLE);
                    CreateUserRequestModel user=new CreateUserRequestModel(
                            name.getText().toString(),
                            email.getText().toString(),
                            contact.getText().toString(),
                            password.getText().toString(),
                            "user"
                    );
                    CreateUserPresenter presenter=new CreateUserPresenter();
                    presenter.createUser(CreateUserActivity.this,user);
                }
            }
        });
    }

    @Override
    public void onCreateUserSuccess(CommonResponse response) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, ""+response.getDescription(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCreateUserFail(String msg) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();
    }
}