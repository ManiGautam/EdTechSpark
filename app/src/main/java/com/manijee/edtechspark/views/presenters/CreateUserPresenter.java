package com.manijee.edtechspark.views.presenters;

import android.util.Log;

import com.manijee.edtechspark.model.CommonResponse;
import com.manijee.edtechspark.model.CreateUserRequestModel;
import com.manijee.edtechspark.repository.ApiManager;
import com.manijee.edtechspark.repository.CreateUserListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateUserPresenter {
    public void createUser(CreateUserListener listener,CreateUserRequestModel user){
       Call<CommonResponse> call= ApiManager.getInstance().getMyApi().createUser(user);
       call.enqueue(new Callback<CommonResponse>() {
           @Override
           public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
               Log.e("response", String.valueOf(response.code()));
               if (response.code()==201) {
                   CommonResponse response1= response.body();
                   listener.onCreateUserSuccess(response1);
               }else{
                 listener.onCreateUserFail("Could not register,Please try agin later"+response.code()+":"+response.message());

               }
           }

           @Override
           public void onFailure(Call<CommonResponse> call, Throwable t) {
            listener.onCreateUserFail(t.getMessage());
           }
       });
    }
}
