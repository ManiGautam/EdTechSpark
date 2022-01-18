package com.manijee.edtechspark.model;

public class CommonResponse {
    int Code;
    String Description;

    public CommonResponse(int code, String description) {
        Code = code;
        Description = description;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
