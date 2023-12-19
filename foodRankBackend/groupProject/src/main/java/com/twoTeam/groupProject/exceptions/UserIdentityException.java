package com.twoTeam.groupProject.exceptions;


public class UserIdentityException extends RuntimeException{
    public UserIdentityException() {
    }

    public UserIdentityException(String s) {
        super(s);
    }

    public UserIdentityException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UserIdentityException(Throwable throwable) {
        super(throwable);
    }

    public UserIdentityException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
