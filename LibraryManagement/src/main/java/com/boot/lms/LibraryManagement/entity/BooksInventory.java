package com.boot.lms.LibraryManagement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@Table
@Builder
@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BooksInventory {
    @Id
    @Column(name = "book_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(name = "book_Name")
    private String bookName;
    @Column(name = "author1")
    private String author1;
    @Column(name = "author2")
    private String author2;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "year_Of_Publication")
    private String yearOfPublication;
    @Column(name = "no_Of_Books")
    private int noOfBooks;
    @Column(name = "available_Books")
    private int availableBooks;
}
