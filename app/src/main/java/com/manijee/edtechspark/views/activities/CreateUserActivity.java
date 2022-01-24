package com.manijee.edtechspark.views.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.manijee.edtechspark.R;
import com.manijee.edtechspark.common.Utills;
import com.manijee.edtechspark.model.CreateUserRequestModel;
import com.manijee.edtechspark.repository.CreateUserListener;
import com.manijee.edtechspark.views.presenters.CreateUserPresenter;

import retrofit2.Response;

public class CreateUserActivity extends AppCompatActivity implements CreateUserListener {
CreateUserPresenter createUserPresenter;
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

        email = findViewById(R.id.edtEmail);

        createUserPresenter = new CreateUserPresenter();

        password = findViewById(R.id.edtPassword);
        confirm_pass=findViewById(R.id.edtConfirmPassword);
        name = findViewById(R.id.edtName);
        contact = findViewById(R.id.edtContact);
progressBar = findViewById(R.id.progressBar);

        Register = findViewById(R.id.btnRegister);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(createUserPresenter.ValidateEmail(email)&&createUserPresenter.ValidatePassword(password)&&createUserPresenter.ValidateContact(contact)){
                if (TextUtils.isEmpty(email.getText().toString()) &&
                        TextUtils.isEmpty(password.getText().toString())&&
                        TextUtils.isEmpty(confirm_pass.getText().toString())&&
                        TextUtils.isEmpty(contact.getText().toString())&&
                        TextUtils.isEmpty(name.getText().toString())
                ) {
                    Utills.getInstance().ShowMessage(v.getRootView(),"Id and Password field should not empty");
                }else if(!confirm_pass.getText().toString().equals(password.getText().toString())){
                    Toast.makeText(CreateUserActivity.this, "Password and Confirm password does not match", Toast.LENGTH_SHORT).show();
                    confirm_pass.setText("");
                }
                }else {
                    Utills.getInstance().ShowMessage(v.getRootView(),"Please enter valid email id,password and contact no");
                }
            }
        });
    }

    @Override
    public void onCreateUserSuccess(Response response) {
        progressBar.setVisibility(View.GONE);
        Log.i("register:","Succsess");
        CreateUserRequestModel user = new CreateUserRequestModel(
                email.getText().toString(),
                name.getText().toString(),
                password.getText().toString(),
                confirm_pass.getText().toString(),
                contact.getText().toString(),
                "user"
        );
        CreateUserPresenter presenter = new CreateUserPresenter();
        presenter.createUser(CreateUserActivity.this, user);

    }

    @Override
    public void onCreateUserFail(String msg) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, "error"+msg, Toast.LENGTH_SHORT).show();
    }
}