package com.manijee.edtechspark.repository;

import com.manijee.edtechspark.model.User;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//singolton pattern
public class ApiManager {
    private static ApiManager instance = null;
    private static Api myApi;
    public User user;
    private ApiManager() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(Api.class);
    }

    public static synchronized ApiManager getInstance() {
        if (instance == null) {
            instance = new ApiManager();
        }
        return instance;
    }

    public Api getMyApi() {
        return myApi;
    }

}

