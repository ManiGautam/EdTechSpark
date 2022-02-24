package com.manijee.edtechspark.views.presenters;

import com.manijee.edtechspark.model.AllCoursesresponsemodel;
import com.manijee.edtechspark.repository.AllCourseListner;
import com.manijee.edtechspark.repository.ApiManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllCoursesPresenter {
    public void allcourses(AllCourseListner listener) {
        Call<List<AllCoursesresponsemodel>> call = ApiManager.getInstance().getMyApi().getAllCourses();
        call.enqueue(new Callback<List<AllCoursesresponsemodel>>() {
            @Override
            public void onResponse(Call<List<AllCoursesresponsemodel>> call, Response<List<AllCoursesresponsemodel>> response) {
            //    Log.i("response code", ""+response.body().get(0).getId());
                if (response.code() == 200) {
                    listener.onSuccess(response);
                } else {
                    listener.onFail("Error Accurd please try again later" + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<AllCoursesresponsemodel>> call, Throwable t) {
                listener.onFail("error:"+t.getMessage()+",cause:"+t.getCause());
            }
        });
    }
}
