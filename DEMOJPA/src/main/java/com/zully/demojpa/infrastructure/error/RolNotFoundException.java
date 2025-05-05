package com.zully.demojpa.infrastructure.error;


import org.springframework.http.HttpStatus;

public class RolNotFoundException extends RuntimeException{

    
    private HttpStatus status;
    private String message;

    public RolNotFoundException(String message, HttpStatus statusCode){
        super(message);
        this.message = message;
        this.status= statusCode;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    

}
