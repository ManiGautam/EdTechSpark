package com.manijee.edtechspark.repository;

import com.manijee.edtechspark.model.CommonResponse;

import okhttp3.ResponseBody;
import retrofit2.Response;

public interface CreateUserListener {
    void onCreateUserSuccess(Response response);
    void onCreateUserFail(String msg);
}
