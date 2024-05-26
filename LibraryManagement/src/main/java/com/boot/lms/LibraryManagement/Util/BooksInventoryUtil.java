package com.boot.lms.LibraryManagement.Util;

import com.boot.lms.LibraryManagement.entity.BooksInventory;
import com.boot.lms.LibraryManagement.objects.BooksInventory_Request;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BooksInventoryUtil {
    public static BooksInventory convertBooksInventory_Request_To_BooksInventory(BooksInventory_Request booksInventory_Request) {
        if (booksInventory_Request == null)
            return null;
        return BooksInventory.builder()
                .bookName(booksInventory_Request.getBookName())
                .author1(booksInventory_Request.getAuthor1())
                .author2(booksInventory_Request.getAuthor2())
                .publisher(booksInventory_Request.getPublisher())
                .yearOfPublication(booksInventory_Request.getYearOfPublication())
                .noOfBooks(booksInventory_Request.getNoOfBooks())
                .availableBooks(booksInventory_Request.getAvailableBooks())
                .build();
    }

    public static BooksInventory_Request convert_BooksInventory_To_BooksInventory_Request(BooksInventory booksInventory) {
        if (booksInventory == null)
            return null;
        return BooksInventory_Request.builder()
                .bookId(booksInventory.getBookId())
                .bookName(booksInventory.getBookName())
                .author1(booksInventory.getAuthor1())
                .author2(booksInventory.getAuthor2())
                .publisher(booksInventory.getPublisher())
                .yearOfPublication(booksInventory.getYearOfPublication())
                .noOfBooks(booksInventory.getNoOfBooks())
                .availableBooks(booksInventory.getAvailableBooks())
                .build();
    }
}
