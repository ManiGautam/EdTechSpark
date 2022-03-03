package com.manijee.edtechspark.views.activities;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.manijee.edtechspark.model.AllCoursesresponsemodel;
import com.manijee.edtechspark.model.CartRequestmodel;
import com.manijee.edtechspark.model.CartSavedErrorResponsemodel;
import com.manijee.edtechspark.repository.AllCourseListner;
import com.manijee.edtechspark.repository.OnCartItemSaved;
import com.manijee.edtechspark.views.presenters.AllCoursesPresenter;

import java.util.List;

import retrofit2.Response;

public class AllCoursesViewModel extends ViewModel implements AllCourseListner, OnCartItemSaved {
    AllCoursesPresenter coursesPresenter = new AllCoursesPresenter();
    public MutableLiveData<CartSavedErrorResponsemodel> cartSavedResponsemodel = new MutableLiveData<>();
    public MutableLiveData<List<AllCoursesresponsemodel>> courselist = new MutableLiveData<>();

    public void getallCourseList() {
        coursesPresenter.allcourses(AllCoursesViewModel.this);
      //  new MyAsyncTask().doInBackground();
    }

    @Override
    public void onSuccess(Response response) {
        List<AllCoursesresponsemodel> localcourselist = (List<AllCoursesresponsemodel>) response.body();
        courselist.postValue(localcourselist);
    }

    @Override
    public void onFail(String msg) {
        Log.i("error to fetch course", "" + msg);
    }

    public void addthisitemtocart(CartRequestmodel cartRequestmodel) {

   coursesPresenter.addToCart(AllCoursesViewModel.this,cartRequestmodel);

    }

    @Override
    public void onSaveCartResponse(CartSavedErrorResponsemodel cartSavedErrorResponsemodel) {
     cartSavedResponsemodel.postValue(cartSavedErrorResponsemodel);
    }

    @Override
    public void onSaveToCartFail(String msg) {
        Log.i("onsavecartitem",""+msg);
    }


    class MyAsyncTask extends AsyncTask<String, Void, Void> {


        @Override
        protected Void doInBackground(String... strings) {
            AllCoursesPresenter coursesPresenter = new AllCoursesPresenter();

            coursesPresenter.allcourses(AllCoursesViewModel.this);
            return null;
        }
    }
}
