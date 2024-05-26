package com.boot.lms.LibraryManagement.Service;

import com.boot.lms.LibraryManagement.objects.BooksTransaction_Request;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BooksTransactionService {
    BooksTransaction_Request addTransaction(BooksTransaction_Request booksTransaction_Request);

    List<BooksTransaction_Request> getAllTransactions();

    BooksTransaction_Request getTransactionById(int id);

    void deleteTransaction(int id);

}
