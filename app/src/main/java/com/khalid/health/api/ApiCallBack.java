package com.khalid.health.api;


public interface ApiCallBack<T> {
    void onSuccess(T object);

    void onFail();
}
