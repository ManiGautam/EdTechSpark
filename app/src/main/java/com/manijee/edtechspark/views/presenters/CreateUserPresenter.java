package com.manijee.edtechspark.views.presenters;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.widget.EditText;

import com.manijee.edtechspark.model.CreateUserRequestModel;
import com.manijee.edtechspark.repository.ApiManager;
import com.manijee.edtechspark.repository.CreateUserListener;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateUserPresenter {
    public boolean ValidateEmail(EditText edt) {
        if (!TextUtils.isEmpty(edt.getText().toString()) && Patterns.EMAIL_ADDRESS.matcher(edt.getText().toString()).matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ValidatePassword(EditText edt) {
        if (!TextUtils.isEmpty(edt.getText().toString())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ValidateContact(EditText edt) {
        if (!TextUtils.isEmpty(edt.getText().toString()) && Patterns.PHONE.matcher(edt.getText().toString()).matches()) {
            return true;
        } else {
            return false;
        }
    }

    public void createUser(CreateUserListener listener, CreateUserRequestModel user) {
        Call<ResponseBody> call = ApiManager.getInstance().getMyApi().createUser(user);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.i("http_response", String.valueOf(response.code()) + "message:" + response.message() + "body:" + response.body());
                if (response.code() == 201) {
                    listener.onCreateUserSuccess(response);
                } else {
                    listener.onCreateUserFail("Could not register,Please try again later" + response.code() + ":" + response.message());

                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                listener.onCreateUserFail(t.getMessage());
            }
        });
    }
}
