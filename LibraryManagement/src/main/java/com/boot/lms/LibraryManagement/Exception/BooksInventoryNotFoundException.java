package com.boot.lms.LibraryManagement.Exception;

public class BooksInventoryNotFoundException extends RuntimeException
{



    public BooksInventoryNotFoundException(String message) {
        super(message);
    }


    public BooksInventoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }


    public BooksInventoryNotFoundException(Throwable cause) {
        super(cause);
    }
}
