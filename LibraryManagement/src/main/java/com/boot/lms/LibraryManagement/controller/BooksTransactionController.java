package com.boot.lms.LibraryManagement.controller;

import com.boot.lms.LibraryManagement.objects.BooksTransaction_Request;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BooksTransaction")
public interface BooksTransactionController {
    @GetMapping("/")
    List<BooksTransaction_Request> getAllTransactions();

    @GetMapping("/{id}")
    BooksTransaction_Request getTransactionById(@PathVariable int id);

    @DeleteMapping("/{id}")
    void deleteTransaction(@PathVariable int id);
}
