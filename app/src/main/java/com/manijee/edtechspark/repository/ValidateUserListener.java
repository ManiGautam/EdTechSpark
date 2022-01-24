package com.manijee.edtechspark.repository;

import retrofit2.Response;

public interface ValidateUserListener {
    void onValidateUserSuccess(Response response);
    void onValidateUserFail(String msg);
}
