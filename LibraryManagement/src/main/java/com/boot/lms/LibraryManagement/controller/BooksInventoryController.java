package com.boot.lms.LibraryManagement.controller;

import com.boot.lms.LibraryManagement.objects.BooksInventory_Request;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BooksInventory")
public interface BooksInventoryController {
    @GetMapping("/")
    List<BooksInventory_Request> getAllBooks();

    @PostMapping("/addBooks")
    BooksInventory_Request addBooks(@RequestBody BooksInventory_Request booksInventory_request);

    @GetMapping("/{bookId}")
    BooksInventory_Request findById(@PathVariable("bookId") int bookId);

    @DeleteMapping("/{BookId}")
    String deleteALLBooksById(@PathVariable int BookId);

    @PutMapping("/updateBook")
    BooksInventory_Request updateBooks(@RequestBody BooksInventory_Request booksInventory_request);

}
