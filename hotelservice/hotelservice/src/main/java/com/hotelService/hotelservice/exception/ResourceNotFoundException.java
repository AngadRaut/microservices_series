package com.hotelService.hotelservice.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String msg){
        super(msg);
    }
    public ResourceNotFoundException(){
        super();
    }
}