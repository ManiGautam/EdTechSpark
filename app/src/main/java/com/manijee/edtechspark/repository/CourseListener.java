package com.manijee.edtechspark.repository;

import com.manijee.edtechspark.model.SubscibedCourseResponseModel;

import java.util.List;

import retrofit2.Response;

public interface CourseListener {
    void onSuccess(List<SubscibedCourseResponseModel> response);
    void onFail(String msg);
}
