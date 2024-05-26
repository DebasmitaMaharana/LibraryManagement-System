package com.boot.lms.LibraryManagement.controllerImp;

import com.boot.lms.LibraryManagement.Service.BooksTransactionService;
import com.boot.lms.LibraryManagement.controller.BooksTransactionController;
import com.boot.lms.LibraryManagement.objects.BooksTransaction_Request;
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
        return booksTransactionService.getTransactionById(id);
    }

    @Override
    public void deleteTransaction(int id) {
        booksTransactionService.deleteTransaction(id);

    }
}
