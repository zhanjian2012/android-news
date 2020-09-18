package com.information.news.core;

import java.util.Locale;

public class Result<T> {
    private String message;
    private T data;

    public Result() {
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
