package com.manijee.edtechspark.views.presenters;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;

import com.manijee.edtechspark.model.ValidateUserRequestModel;
import com.manijee.edtechspark.model.ValidateUserResponsemodel;
import com.manijee.edtechspark.repository.ApiManager;
import com.manijee.edtechspark.repository.ValidateUserListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class ValidateUserPresenter {

    public boolean ValidateEmail(EditText edt){
        if (!TextUtils.isEmpty(edt.getText().toString())&& Patterns.EMAIL_ADDRESS.matcher(edt.getText().toString()).matches()){
            return true;
        }else{
            return  false;
        }
    }

    public boolean ValidatePassword(EditText edt){
        if (!TextUtils.isEmpty(edt.getText().toString())){
            return true;
        }else{
            return  false;
        }
    }

    public void validateUser(ValidateUserListener listener, ValidateUserRequestModel user){
        Call<ValidateUserResponsemodel> call = ApiManager.getInstance().getMyApi().validateUser(user);
        call.enqueue(new Callback<ValidateUserResponsemodel>() {

            @Override
            public void onResponse(Call<ValidateUserResponsemodel> call, Response<ValidateUserResponsemodel> response) {
                if (response.code() == 200){
                    listener.onValidateUserSuccess(response);
                }else {
                    listener.onValidateUserFail("Could not Validate your Details,Please try again later" + response.code() + ":" + response.message());
                }
            }

            @Override
            public void onFailure(Call<ValidateUserResponsemodel> call, Throwable t) {
                listener.onValidateUserFail(t.getMessage());
            }

        });

    }
}
