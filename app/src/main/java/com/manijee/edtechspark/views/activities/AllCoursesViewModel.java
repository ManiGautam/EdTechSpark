package com.manijee.edtechspark.views.activities;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.manijee.edtechspark.model.AllCoursesresponsemodel;
import com.manijee.edtechspark.repository.AllCourseListner;
import com.manijee.edtechspark.views.presenters.AllCoursesPresenter;

import java.util.List;

import retrofit2.Response;

public class AllCoursesViewModel extends ViewModel implements AllCourseListner {
    public MutableLiveData<List<AllCoursesresponsemodel>> courselist = new MutableLiveData<>();

    public void getallCourseList() {
        AllCoursesPresenter coursesPresenter = new AllCoursesPresenter();

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


    class MyAsyncTask extends AsyncTask<String, Void, Void> {


        @Override
        protected Void doInBackground(String... strings) {
            AllCoursesPresenter coursesPresenter = new AllCoursesPresenter();

            coursesPresenter.allcourses(AllCoursesViewModel.this);
            return null;
        }
    }
}
