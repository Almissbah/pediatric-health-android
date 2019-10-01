package com.almissbah.health.api;


public interface ApiCallBack<T> {
    void onSuccess(T object);

    void onFail();
}
