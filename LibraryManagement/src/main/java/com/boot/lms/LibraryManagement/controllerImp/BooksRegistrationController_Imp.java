package com.boot.lms.LibraryManagement.controllerImp;

import com.boot.lms.LibraryManagement.Exception.UserNotFoundException;
import com.boot.lms.LibraryManagement.Service.BooksRegistrationService;
import com.boot.lms.LibraryManagement.controller.BooksRegistrationController;
import com.boot.lms.LibraryManagement.objects.BooksRegistration_Request;
import com.boot.lms.LibraryManagement.objects.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/BooksRegistration")
public class BooksRegistrationController_Imp implements BooksRegistrationController {
    @Autowired
    BooksRegistrationService booksRegistrationService;

    @Override
    public List<BooksRegistration_Request> listOfAllRegisteredBook() {
        return booksRegistrationService.getAllRegisteredBook();
    }

    @Override
    public BooksRegistration_Request registerABook(@RequestBody BooksRegistration_Request booksRegistration_request) {

        return booksRegistrationService.registerBook(booksRegistration_request);
    }

    @Override
    public BooksRegistration_Request getBooksRegistrationById(@PathVariable int registrationId) {

        BooksRegistration_Request booksRegistration_request= booksRegistrationService.getBooksById(registrationId);

        if (booksRegistration_request == null)
            throw new UserNotFoundException("BookRegistration id not found-" + registrationId);
        return booksRegistration_request;
    }

    @Override
    public String deleteABookRegistration(@PathVariable int registrationId) {
//        booksRegistrationService.deleteBook(registrationId);
//        return "data deleted successfully for id" + registrationId;

        BooksRegistration_Request booksRegistration_request = booksRegistrationService.getBooksById(registrationId);
        if (booksRegistration_request == null)
            throw new RuntimeException("BookRegistration id not found" + registrationId);
        booksRegistrationService.deleteBook(registrationId);
        return "deleted BookRegistration id- " + registrationId;

    }

    @Override
    public BooksRegistration_Request updateRegistration(@RequestBody BooksRegistration_Request booksRegistration_request) {
        return booksRegistrationService.updateRegistration(booksRegistration_request);
    }
}
