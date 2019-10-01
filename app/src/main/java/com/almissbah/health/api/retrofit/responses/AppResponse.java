package com.almissbah.health.api.retrofit.responses;

public class AppResponse {
    int success = 0;
    int lock_app = 0;
    String message = "Server Error";
    public boolean isSuccess() {
        if (success == 1) return true;
        else return false;
    }

    public int getLock_app() {
        return lock_app;
    }

    public void setLock_app(int lock_app) {
        this.lock_app = lock_app;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
