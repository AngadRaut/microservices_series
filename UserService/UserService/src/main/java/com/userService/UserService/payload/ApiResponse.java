package com.userService.UserService.payload;

import org.springframework.http.HttpStatus;

public class ApiResponse {
    private String msg ;
    private boolean success;
    private HttpStatus status;

    public ApiResponse(String msg, boolean success, HttpStatus status) {
        this.msg = msg;
        this.success = success;
        this.status = status;
    }

    public ApiResponse() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
