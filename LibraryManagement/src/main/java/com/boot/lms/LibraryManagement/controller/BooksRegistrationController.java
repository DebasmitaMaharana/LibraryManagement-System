package com.boot.lms.LibraryManagement.controller;

import com.boot.lms.LibraryManagement.objects.BooksRegistration_Request;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BooksRegistration")
public interface BooksRegistrationController {
    @GetMapping("/")
    List<BooksRegistration_Request> listOfAllRegisteredBook();

    @PostMapping("/register")
    BooksRegistration_Request registerABook(@RequestBody BooksRegistration_Request booksRegistration_request);

    @GetMapping("/{registrationId}")
    BooksRegistration_Request getBooksRegistrationById(@PathVariable int registrationId);

    @DeleteMapping("/{registrationId}")
    String deleteABookRegistration(@PathVariable int registrationId);

    @PutMapping("/update")
    BooksRegistration_Request updateRegistration(@RequestBody BooksRegistration_Request booksRegistration_request);
}
