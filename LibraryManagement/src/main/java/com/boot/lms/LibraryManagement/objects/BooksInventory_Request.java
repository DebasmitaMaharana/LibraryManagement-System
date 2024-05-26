package com.boot.lms.LibraryManagement.objects;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BooksInventory_Request {
    private int bookId;
    private String bookName;
    private String author1;
    private String author2;
    private String publisher;
    private String yearOfPublication;
    private int noOfBooks;
    private int availableBooks;
}
