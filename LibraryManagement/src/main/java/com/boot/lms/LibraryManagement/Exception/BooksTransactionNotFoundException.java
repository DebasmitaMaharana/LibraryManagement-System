package com.boot.lms.LibraryManagement.Exception;

public class BooksTransactionNotFoundException extends RuntimeException
{

    public BooksTransactionNotFoundException(String message) {
        super(message);
    }


    public BooksTransactionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }


    public BooksTransactionNotFoundException(Throwable cause) {
        super(cause);
    }
}
