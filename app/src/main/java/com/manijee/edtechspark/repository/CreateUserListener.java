package com.manijee.edtechspark.repository;

import com.manijee.edtechspark.model.CommonResponse;

public interface CreateUserListener {
    void onCreateUserSuccess(CommonResponse response);
    void onCreateUserFail(String msg);
}
