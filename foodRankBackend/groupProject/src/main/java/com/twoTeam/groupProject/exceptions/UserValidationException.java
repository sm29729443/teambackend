package com.twoTeam.groupProject.exceptions;


public class UserValidationException extends RuntimeException{
    public UserValidationException() {
    }

    public UserValidationException(String s) {
        super(s);
    }

    public UserValidationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UserValidationException(Throwable throwable) {
        super(throwable);
    }

    public UserValidationException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
