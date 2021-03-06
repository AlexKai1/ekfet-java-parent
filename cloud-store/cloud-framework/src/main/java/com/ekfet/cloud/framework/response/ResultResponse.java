package com.ekfet.cloud.framework.response;

import java.io.Serializable;

public class ResultResponse<T extends Serializable> {

    private int code = 200;
    private String message = "Success";
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public ResultResponse() {
    }

    public ResultResponse(T data) {
        this.data = data;
    }

    public ResultResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
