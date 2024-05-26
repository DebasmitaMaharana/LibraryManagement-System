package com.boot.lms.LibraryManagement.Util;

import com.boot.lms.LibraryManagement.entity.BooksTransaction;
import com.boot.lms.LibraryManagement.objects.BooksTransaction_Request;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class BooksTransactionUtil {
    public BooksTransaction convertBooksTransaction_RequestToBooksTransaction(BooksTransaction_Request booksTransaction_request) {
        if (booksTransaction_request == null) {
            return null;
        }
        return BooksTransaction.builder()
                .transactionId(booksTransaction_request.getTransactionId())
                .registrationId(booksTransaction_request.getRegistrationId())
                .issueDate(LocalDateTime.now())
                .fine(booksTransaction_request.getFine())
                .returnDate(booksTransaction_request.getReturnDate())
                .build();
    }

    public BooksTransaction_Request convertBooksTransactionToBooksTransaction_Request(BooksTransaction booksTransaction) {
        if (booksTransaction == null) {
            return null;
        }
        return BooksTransaction_Request.builder()
                .transactionId(booksTransaction.getTransactionId())
                .registrationId(booksTransaction.getRegistrationId())
                .issueDate(LocalDateTime.now())
                .returnDate(booksTransaction.getReturnDate())
                .fine(booksTransaction.getFine())
                .build();
    }

    public BooksTransaction_Request getBooksTransaction_Request(Integer registrationId, LocalDateTime registrationDate) {
        return BooksTransaction_Request.builder().
                registrationId(registrationId).
                returnDate(registrationDate.plusDays(7)).
                issueDate(registrationDate).
                fine(0).
                build();
    }
}
