package com.manijee.edtechspark.views.presenters;

import android.util.Log;

import com.manijee.edtechspark.model.SubscibedCourseResponseModel;
import com.manijee.edtechspark.repository.ApiManager;
import com.manijee.edtechspark.repository.CourseListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubcribedCoursePresenter {
    public void getSubscribedCourseByUserId(CourseListener listener, String UserId) {
        Call<List<SubscibedCourseResponseModel>> call = ApiManager.getInstance().getMyApi().getsubscibedcoursesbyuserid(UserId);
        call.enqueue(new Callback<List<SubscibedCourseResponseModel>>() {
            @Override
            public void onResponse(Call<List<SubscibedCourseResponseModel>> call, Response<List<SubscibedCourseResponseModel>> response) {
                Log.i("response code", "" + response.code() + response.message());
                if (response.code() == 200) {
                    listener.onSuccess(response);
                } else {

                    listener.onFail("Error Accurd please try again later" + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<SubscibedCourseResponseModel>> call, Throwable t) {
                listener.onFail(t.getMessage());
            }
        });
    }
}
