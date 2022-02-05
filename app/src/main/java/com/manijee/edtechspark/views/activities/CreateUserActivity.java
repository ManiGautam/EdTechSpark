package com.manijee.edtechspark.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.manijee.edtechspark.R;
import com.manijee.edtechspark.common.PreferenceManager;
import com.manijee.edtechspark.common.Utills;
import com.manijee.edtechspark.model.CreateUserRequestModel;
import com.manijee.edtechspark.repository.CreateUserListener;
import com.manijee.edtechspark.views.presenters.CreateUserPresenter;

import retrofit2.Response;

public class CreateUserActivity extends AppCompatActivity implements CreateUserListener {
    View view;
    TextView validemail, validpassword, validcontact;
    CreateUserPresenter createUserPresenter;
    ProgressBar progressBar;
    EditText email, password, confirm_pass, contact, name;
    PreferenceManager preferenceManager;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createuser);

        preferenceManager = PreferenceManager.getInstance(this);

        email = findViewById(R.id.edtEmail);

        validemail = findViewById(R.id.edtplsremail);

        validemail.setVisibility(View.INVISIBLE);

        validpassword = findViewById(R.id.edtplsrpassword);

        validpassword.setVisibility(View.INVISIBLE);

        validcontact = findViewById(R.id.edtplsrcontact);

        validcontact.setVisibility(View.INVISIBLE);


        view = email.getRootView();

        createUserPresenter = new CreateUserPresenter();

        password = findViewById(R.id.edtPassword);
        confirm_pass = findViewById(R.id.edtConfirmPassword);
        name = findViewById(R.id.edtName);
        contact = findViewById(R.id.edtContact);
        progressBar = findViewById(R.id.progressBar);
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validemail.setVisibility(View.INVISIBLE);
                validpassword.setVisibility(View.INVISIBLE);
                validcontact.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Register = findViewById(R.id.btnRegister);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (createUserPresenter.ValidateEmail(email) && createUserPresenter.ValidatePassword(password) && createUserPresenter.ValidateContact(contact)) {
                    if (TextUtils.isEmpty(email.getText().toString()) &&
                            TextUtils.isEmpty(password.getText().toString()) &&
                            TextUtils.isEmpty(confirm_pass.getText().toString()) &&
                            TextUtils.isEmpty(contact.getText().toString()) &&
                            TextUtils.isEmpty(name.getText().toString())

                    ) {
                        validemail.setVisibility(View.VISIBLE);
                        validpassword.setVisibility(View.VISIBLE);
                        validcontact.setVisibility(View.VISIBLE);
                    } else if (!confirm_pass.getText().toString().equals(password.getText().toString())) {
                        Toast.makeText(CreateUserActivity.this, "Password and Confirm password does not match", Toast.LENGTH_SHORT).show();
                        confirm_pass.setText("");
                    } else {
                        progressBar.setVisibility(View.VISIBLE);
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
                } else {
                    Utills.getInstance().ShowMessage(v.getRootView(), "Please enter valid email id,password and contact no");
                }
            }
        });
    }

    @Override
    public void onCreateUserSuccess(Response response) {

        progressBar.setVisibility(View.GONE);
        Log.i("register:", "Succsess");
        Utills.getInstance().ShowMessage(view, "201:" + response.message());
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }

    @Override
    public void onCreateUserFail(String msg) {
        progressBar.setVisibility(View.GONE);
        Utills.getInstance().ShowMessage(view, "error" + msg);
    }
}