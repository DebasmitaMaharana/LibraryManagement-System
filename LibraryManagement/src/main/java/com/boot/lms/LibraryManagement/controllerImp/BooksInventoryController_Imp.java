package com.boot.lms.LibraryManagement.controllerImp;

import com.boot.lms.LibraryManagement.Exception.UserNotFoundException;
import com.boot.lms.LibraryManagement.controller.BooksInventoryController;
import com.boot.lms.LibraryManagement.objects.BooksInventory_Request;
import com.boot.lms.LibraryManagement.objects.UserRequest;
import com.boot.lms.LibraryManagement.serviceImp.BooksInventoryService_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class BooksInventoryController_Imp implements BooksInventoryController {
    @Autowired
    BooksInventoryService_Imp booksInventoryService_Imp;

    @Override
    public List<BooksInventory_Request> getAllBooks() {
        return booksInventoryService_Imp.getAllBooks();



    }

    @Override
    public BooksInventory_Request addBooks(BooksInventory_Request booksInventory_request) {
        return booksInventoryService_Imp.save(booksInventory_request);

    }

    @Override
    public BooksInventory_Request findById(int BookId) {
        BooksInventory_Request booksInventory_request= booksInventoryService_Imp.findById(BookId);

        if (booksInventory_request == null)
            throw new UserNotFoundException("Book id not found-" + BookId);
        return booksInventory_request;
    }

    @Override
    public String deleteALLBooksById(int BookId)
    {
//        booksInventoryService_Imp.deleteALLBooksById(BookId);
//        return "all books are deleted of id" + BookId;

        BooksInventory_Request booksInventory_request=booksInventoryService_Imp.findById(BookId);
        if (booksInventory_request == null)
            throw new RuntimeException("Book id not found" + BookId);
        booksInventoryService_Imp.deleteALLBooksById(BookId);
        return "deleted Book id- " + BookId;

    }

    @Override
    public BooksInventory_Request updateBooks(@RequestBody BooksInventory_Request booksInventory_request) {
        return booksInventoryService_Imp.updateBook(booksInventory_request);
    }
}
