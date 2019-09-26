package com.ekfet.boothystrix;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private int code = 200;
    private String message = "Success";
    private T data;

    public ApiResponse(T data) {
        this.data = data;
    }

    public ApiResponse() {
    }

}
