package com.boot.lms.LibraryManagement.Exception;

public class BooksRegistrationNotFoundException extends RuntimeException
{

    public BooksRegistrationNotFoundException(String message) {
        super(message);
    }


    public BooksRegistrationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }


    public BooksRegistrationNotFoundException(Throwable cause) {
        super(cause);
    }
}
