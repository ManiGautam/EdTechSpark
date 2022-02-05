package com.manijee.edtechspark.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.manijee.edtechspark.R;
import com.manijee.edtechspark.common.PreferenceManager;
import com.manijee.edtechspark.common.Utills;
import com.manijee.edtechspark.model.ValidateUserRequestModel;
import com.manijee.edtechspark.model.ValidateUserResponsemodel;
import com.manijee.edtechspark.repository.ValidateUserListener;
import com.manijee.edtechspark.views.presenters.ValidateUserPresenter;

import retrofit2.Response;

public class LoginPage extends AppCompatActivity implements ValidateUserListener {
    CheckBox ck;
    ValidateUserResponsemodel validateUserResponsemodel;
    ProgressBar progressBar;
    EditText email, password;
    TextView validemail,validpassword;
    PreferenceManager preferenceManager;
    Button Login;
    TextView Register;
    ValidateUserPresenter validateUserPresenter;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        ck = findViewById(R.id.ck);

        preferenceManager = PreferenceManager.getInstance(this);

        validateUserPresenter = new ValidateUserPresenter();

        validemail = findViewById(R.id.edtplsemail);

        validemail.setVisibility(View.INVISIBLE);

        validpassword = findViewById(R.id.edtplspassword);

        validpassword.setVisibility(View.INVISIBLE);

        email = findViewById(R.id.edtEmail);

        view = email.getRootView();


        password = findViewById(R.id.edtPassword);

        progressBar = findViewById(R.id.progressBar);

        String remember=preferenceManager.getInfo("rememberemail");

        if (remember!=null&&!remember.isEmpty()){
            startActivity(new Intent(LoginPage.this,MainActivity.class));
            finish();
        }

        ck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Register = findViewById(R.id.Notregisteryet);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(LoginPage.this, CreateUserActivity.class);
                startActivity(register);
            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validemail.setVisibility(View.INVISIBLE);
                validpassword.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Login = findViewById(R.id.btnLogin);
            Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (validateUserPresenter.ValidateEmail(email) && validateUserPresenter.ValidatePassword(password)) {
                        ValidateUserDetalisfromserver();
                    }else {
                        validemail.setVisibility(View.VISIBLE);
                        validpassword.setVisibility(View.VISIBLE);
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
        validateUserPresenter.validateUser(this, user);

    }

    @Override
    public void onValidateUserSuccess(Response response) {
        preferenceManager.setInfo("email", validateUserResponsemodel.email);
        preferenceManager.setInfo("name", validateUserResponsemodel.name);
        preferenceManager.setInfo("token",validateUserResponsemodel.token);
        progressBar.setVisibility(View.GONE);
        Log.i("login:", "Succsess"+response.code());
        if (ck.isChecked()){
            preferenceManager.setInfo("rememberemail", email.getText().toString());
        }
        validateUserResponsemodel = (ValidateUserResponsemodel) response.body();
        Log.i("login is :", "Validate"+validateUserResponsemodel.email+validateUserResponsemodel.id);
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }

    @Override
    public void onValidateUserFail(String msg) {
        progressBar.setVisibility(View.GONE);
        Utills.getInstance().ShowMessage(view,"User Invalid"+msg);
    }



}