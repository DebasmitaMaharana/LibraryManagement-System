package com.boot.lms.LibraryManagement.controllerImp;

import com.boot.lms.LibraryManagement.Exception.UserNotFoundException;
import com.boot.lms.LibraryManagement.Service.BooksTransactionService;
import com.boot.lms.LibraryManagement.controller.BooksTransactionController;
import com.boot.lms.LibraryManagement.objects.BooksTransaction_Request;
import com.boot.lms.LibraryManagement.objects.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BooksTransactionController_Imp implements BooksTransactionController {
    @Autowired
    BooksTransactionService booksTransactionService;

    @Override
    public List<BooksTransaction_Request> getAllTransactions() {
        return booksTransactionService.getAllTransactions();
    }
    @Override
    public BooksTransaction_Request getTransactionById(int id) {
        BooksTransaction_Request booksTransaction_request= booksTransactionService.getTransactionById(id);

        if (booksTransaction_request == null)
            throw new UserNotFoundException("BooksTransaction id not found-" + id);
        return booksTransaction_request;
    }

    @Override
    public String deleteTransaction(int id) {


        BooksTransaction_Request booksTransaction_request = booksTransactionService.getTransactionById(id);
        if (booksTransaction_request == null)
            throw new RuntimeException("BooksTransaction id not found" + id);
        booksTransactionService.deleteTransaction(id);
        return "deleted BooksTransaction id- " + id;

    }
}
