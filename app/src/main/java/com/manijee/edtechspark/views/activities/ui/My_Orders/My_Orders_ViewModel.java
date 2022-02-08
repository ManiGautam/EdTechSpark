package com.manijee.edtechspark.views.activities.ui.My_Orders;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.manijee.edtechspark.model.MyOrdersResponseModel;
import com.manijee.edtechspark.repository.OrdersListener;
import com.manijee.edtechspark.views.presenters.MyOrdersPresenter;

import java.util.List;

import retrofit2.Response;

public class My_Orders_ViewModel extends ViewModel implements OrdersListener {

    private MutableLiveData<String> mText;
    public MutableLiveData<List<MyOrdersResponseModel>> orderslist = new MutableLiveData<>();
    public My_Orders_ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
    public void getordersbyuserid(String UserId){
        new MyAsyncTask().doInBackground(UserId);
    }
    @Override
    public void onSuccess(Response response) {
        List<MyOrdersResponseModel> localcourselist = (List<MyOrdersResponseModel>) response.body();
        orderslist.postValue(localcourselist);
    }

    @Override
    public void onFail(String msg) {
        Log.i("error to fetch orders",""+msg);
    }
    class MyAsyncTask extends AsyncTask<String,Void,Void> {



        @Override
        protected Void doInBackground(String... strings) {
            MyOrdersPresenter myOrdersPresenter = new MyOrdersPresenter();

             myOrdersPresenter.getuserorder(My_Orders_ViewModel.this,strings[0]);
            return null;
        }
    }
}