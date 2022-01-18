package com.manijee.edtechspark.views.presenters;

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
               if (response.code()==201) {
                   CommonResponse response1= response.body();
                   listener.onCreateUserSuccess(response.body());
               }else{
                 listener.onCreateUserFail("Could not register,Please try agin later");
               }
           }

           @Override
           public void onFailure(Call<CommonResponse> call, Throwable t) {
            listener.onCreateUserFail(t.getMessage());
           }
       });
    }
}
