package com.boot.lms.LibraryManagement.Exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }


    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }


    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
