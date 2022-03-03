package com.manijee.edtechspark.views.presenters;

import android.util.Log;

import com.manijee.edtechspark.model.AllCoursesresponsemodel;
import com.manijee.edtechspark.model.CartRequestmodel;
import com.manijee.edtechspark.model.CartSavedErrorResponsemodel;
import com.manijee.edtechspark.repository.AllCourseListner;
import com.manijee.edtechspark.repository.ApiManager;
import com.manijee.edtechspark.repository.OnCartItemSaved;

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
    public void addToCart(OnCartItemSaved listner, CartRequestmodel cartRequestmodel){
        Call<CartSavedErrorResponsemodel> call = ApiManager.getInstance().getMyApi().SaveCart(cartRequestmodel);
        call.enqueue(new Callback<CartSavedErrorResponsemodel>() {
            @Override
            public void onResponse(Call<CartSavedErrorResponsemodel> call, Response<CartSavedErrorResponsemodel> response) {
                if (response.isSuccessful()&&response.code() == 200){
                    listner.onSaveCartResponse(response.body());
                }else {
                    Log.i("cart",response.message());
                }
            }

            @Override
            public void onFailure(Call<CartSavedErrorResponsemodel> call, Throwable t) {
                listner.onSaveToCartFail(t.getMessage());
            }
        });
    }
}
