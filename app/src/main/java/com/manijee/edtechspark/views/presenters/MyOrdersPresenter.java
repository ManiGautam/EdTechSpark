package com.manijee.edtechspark.views.presenters;

import android.util.Log;

import com.manijee.edtechspark.model.MyOrdersResponseModel;
import com.manijee.edtechspark.repository.ApiManager;
import com.manijee.edtechspark.repository.OrdersListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyOrdersPresenter {
    public void getuserorder(OrdersListener listener, String UserId) {
    Call<List<MyOrdersResponseModel>> call = ApiManager.getInstance().getMyApi().getuserorder(UserId);
    call.enqueue(new Callback<List<MyOrdersResponseModel>>() {
        @Override
        public void onResponse(Call<List<MyOrdersResponseModel>> call, Response<List<MyOrdersResponseModel>> response) {
            Log.i("response code", "" + response.code() + response.message());
            if (response.code() == 200) {
                listener.onSuccess(response);
            } else {

                listener.onFail("Error Accurd please try again later" + response.code());
            }
        }

        @Override
        public void onFailure(Call<List<MyOrdersResponseModel>> call, Throwable t) {
            listener.onFail(t.getMessage());
        }
    });
}

}
