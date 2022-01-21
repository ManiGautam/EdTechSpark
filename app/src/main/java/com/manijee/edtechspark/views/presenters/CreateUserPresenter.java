package com.manijee.edtechspark.views.presenters;

import android.util.Log;

import com.manijee.edtechspark.model.CommonResponse;
import com.manijee.edtechspark.model.CreateUserRequestModel;
import com.manijee.edtechspark.repository.ApiManager;
import com.manijee.edtechspark.repository.CreateUserListener;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateUserPresenter {
    public void createUser(CreateUserListener listener, CreateUserRequestModel user) {
        Call<ResponseBody> call = ApiManager.getInstance().getMyApi().createUser(user);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.i("http_response", String.valueOf(response.code())+"message:"+response.message()+"body:"+response.body());
                if (response.code() == 201) {
                  listener.onCreateUserSuccess(response);
                } else {
                    listener.onCreateUserFail("Could not register,Please try agin later" + response.code() + ":" + response.message());

                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                listener.onCreateUserFail(t.getMessage());
            }
        });
    }
}
