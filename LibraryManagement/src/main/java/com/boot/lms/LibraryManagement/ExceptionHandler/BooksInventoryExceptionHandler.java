package com.boot.lms.LibraryManagement.ExceptionHandler;

import com.boot.lms.LibraryManagement.Exception.UserNotFoundException;
import com.boot.lms.LibraryManagement.errorResponse.BooksInventoryErrorresponse;
import com.boot.lms.LibraryManagement.errorResponse.UserErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BooksInventoryExceptionHandler
{
    @ExceptionHandler
    public ResponseEntity<BooksInventoryErrorresponse> handleException(UserNotFoundException exception) {
        BooksInventoryErrorresponse error = new BooksInventoryErrorresponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<BooksInventoryErrorresponse> handleException(Exception exception) {
        BooksInventoryErrorresponse error = new BooksInventoryErrorresponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
