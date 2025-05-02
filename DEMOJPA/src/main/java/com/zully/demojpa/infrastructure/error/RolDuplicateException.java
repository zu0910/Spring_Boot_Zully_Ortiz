package com.zully.demojpa.infrastructure.error;

import org.springframework.http.HttpStatus;

public class RolDuplicateException extends RuntimeException{

    private String message;
    private HttpStatus status;

    public RolDuplicateException(String message, HttpStatus statusCode){
        super(message);
        this.message = message;
        this.status = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    


}
