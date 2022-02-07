package com.manijee.edtechspark.views.activities.ui.My_Orders;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class My_Orders_ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public My_Orders_ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}