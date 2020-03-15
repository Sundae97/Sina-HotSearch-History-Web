package com.sundae.sinaspider.dto;

public class GeneralResponse<T> {

    private boolean success;
    private int code;
    private T data;

    public GeneralResponse() {
    }

    public GeneralResponse(boolean success) {
        this(success, 0);
    }

    public GeneralResponse(boolean success, int code) {
        this(success, code, null);
    }

    public GeneralResponse(boolean success, int code, T data) {
        this.success = success;
        this.code = code;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
