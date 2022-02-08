package com.manijee.edtechspark.repository;

import retrofit2.Response;

public interface OrdersListener {
    void onSuccess(Response response);
    void onFail(String msg);
}
