package com.boot.lms.LibraryManagement.Service;

import com.boot.lms.LibraryManagement.objects.BooksRegistration_Request;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BooksRegistrationService {
    List<BooksRegistration_Request> getAllRegisteredBook();

    BooksRegistration_Request registerBook(BooksRegistration_Request booksRegistration_request);

    BooksRegistration_Request getBooksById(int id);

    void deleteBook(int id);

    BooksRegistration_Request updateRegistration(BooksRegistration_Request booksRegistration_request);

}
