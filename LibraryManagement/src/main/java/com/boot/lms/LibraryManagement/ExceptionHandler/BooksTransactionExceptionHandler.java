package com.boot.lms.LibraryManagement.ExceptionHandler;

import com.boot.lms.LibraryManagement.Exception.UserNotFoundException;
import com.boot.lms.LibraryManagement.errorResponse.BooksTransactionErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BooksTransactionExceptionHandler
{
    @ExceptionHandler
    public ResponseEntity<BooksTransactionErrorResponse> handleException(UserNotFoundException exception) {
        BooksTransactionErrorResponse error = new BooksTransactionErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<BooksTransactionErrorResponse> handleException(Exception exception) {
        BooksTransactionErrorResponse error = new BooksTransactionErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
