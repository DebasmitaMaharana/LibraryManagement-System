package com.boot.lms.LibraryManagement.Util;


import com.boot.lms.LibraryManagement.entity.BooksRegistration;
import com.boot.lms.LibraryManagement.objects.BooksRegistration_Request;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class BooksRegistrationUtil {
    public static BooksRegistration_Request convertBooksRegistrationToBooksRegistration_Request(BooksRegistration booksRegistration) {
        if (booksRegistration == null)
            return null;
        return BooksRegistration_Request.builder()
                .registrationId(booksRegistration.getRegistrationId())
                .registrationDate(LocalDateTime.now())
                .bookId(booksRegistration.getBookId())
                .userId(booksRegistration.getUserId()).build();


    }

    public static BooksRegistration convertBooksRegistration_RequestToBooksRegistration(BooksRegistration_Request booksRegistration_Request) {
        if (booksRegistration_Request == null)
            return null;
        return BooksRegistration.builder()
                .registrationId(booksRegistration_Request.getRegistrationId())
                .registrationDate(LocalDateTime.now())
                .bookId(booksRegistration_Request.getBookId())
                .userId(booksRegistration_Request.getUserId())
                .build();

    }
}
