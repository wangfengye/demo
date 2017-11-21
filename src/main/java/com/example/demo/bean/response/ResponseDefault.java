package com.example.demo.bean.response;

/**
 * @author wangfeng
 * Created by lenovo on 2017/9/11.
 */
public class ResponseDefault<T> {
    private int status = 200;
    private String message ="success";
    private T data;

    public ResponseDefault(T data) {
        this.data = data;
    }
    public ResponseDefault() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

}
