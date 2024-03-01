package com.blogApi.exceptions;

public class UserAlreadyExistException extends Exception {

    public String email;
    public UserAlreadyExistException(String email){
        super(String.format("User with given email: %s already exist", email));
        this.email = email;
    }
}
