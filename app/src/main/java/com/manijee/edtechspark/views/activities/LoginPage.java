package com.manijee.edtechspark.views.activities;

import android.content.Intent;
import android.os.Bundle;
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
import com.manijee.edtechspark.model.ValidateUserRequestModel;
import com.manijee.edtechspark.repository.ValidateUserListener;
import com.manijee.edtechspark.views.presenters.ValidateUserPresenter;

import retrofit2.Response;

public class LoginPage extends AppCompatActivity implements ValidateUserListener {
    ProgressBar progressBar;
    EditText email, password;
    PreferenceManager preferenceManager;
    Button Login;
    TextView Register;
ValidateUserPresenter validateUserPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        preferenceManager = PreferenceManager.getInstance(this);

        validateUserPresenter = new ValidateUserPresenter();

        email = findViewById(R.id.edtName);

        password = findViewById(R.id.edtEmail);

        progressBar = findViewById(R.id.progressBar);

Register = findViewById(R.id.Notregisteryet);
Register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent register = new Intent(LoginPage.this,CreateUserActivity.class);
        startActivity(register);
    }
});
        Login = findViewById(R.id.btnLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(validateUserPresenter.ValidateEmail(email)&&validateUserPresenter.ValidatePassword(password)){
                   ValidateUserDetalisfromserver();
               }else {
                    Utills.getInstance().ShowMessage(v.getRootView(),"Please enter valid email id and password");
               }


            }
        });
    }

    private void ValidateUserDetalisfromserver() {
        progressBar.setVisibility(View.VISIBLE);
        ValidateUserRequestModel user = new ValidateUserRequestModel(
                email.getText().toString(),
                password.getText().toString()
        );
        validateUserPresenter.validateUser(this,user);

    }


    @Override
    public void onValidateUserSuccess(Response response) {
        progressBar.setVisibility(View.GONE);
       // ValidateUserResponsemodel validateUserResponsemodel = response.body();
        Log.i("login:","Succsess");
        Intent move = new Intent(LoginPage.this,MainActivity.class);
        startActivity(move);
    }

    @Override
    public void onValidateUserFail(String msg) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();
    }


}