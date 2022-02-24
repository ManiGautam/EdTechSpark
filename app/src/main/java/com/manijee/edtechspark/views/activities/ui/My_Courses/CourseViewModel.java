package com.manijee.edtechspark.views.activities.ui.My_Courses;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.manijee.edtechspark.model.SubscibedCourseResponseModel;
import com.manijee.edtechspark.repository.CourseListener;
import com.manijee.edtechspark.views.presenters.SubcribedCoursePresenter;

import java.util.List;

import retrofit2.Response;

public class CourseViewModel extends ViewModel implements CourseListener {

    private MutableLiveData<String> mText;
    public MutableLiveData<List<SubscibedCourseResponseModel>> courselist = new MutableLiveData<>();
    public CourseViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
    public void getSubcibedCourseList(String UserId){
    new MyAsyncTask().doInBackground(UserId);
    }

    @Override
    public void onSuccess(List<SubscibedCourseResponseModel> localcourselist) {
        Log.i("obtained_records",localcourselist.get(0).getName()+","+localcourselist.get(0).getName());
        courselist.setValue(localcourselist);
    }

    @Override
    public void onFail(String msg) {
        Log.i("error to fetch course",""+msg);
    }

    class MyAsyncTask extends AsyncTask<String,Void,Void> {

        @Override
        protected Void doInBackground(String... strings) {
            SubcribedCoursePresenter subcribedCoursePresenter = new SubcribedCoursePresenter();

            subcribedCoursePresenter.getSubscribedCourseByUserId(CourseViewModel.this,strings[0]);
            return null;
        }
    }
}