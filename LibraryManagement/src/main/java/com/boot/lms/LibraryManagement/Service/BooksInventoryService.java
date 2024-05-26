package com.boot.lms.LibraryManagement.Service;

import com.boot.lms.LibraryManagement.objects.BooksInventory_Request;

import java.util.List;

public interface BooksInventoryService {
    List<BooksInventory_Request> getAllBooks();

    BooksInventory_Request save(BooksInventory_Request booksInventory);

    BooksInventory_Request findById(int id);

    void deleteALLBooksById(int id);

    //int removeBooksOfAId(int id);
    BooksInventory_Request updateBook(BooksInventory_Request booksInventory_Request);

}
