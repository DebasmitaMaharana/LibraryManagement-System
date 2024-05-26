package com.boot.lms.LibraryManagement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Table
@Builder
@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class BooksTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_Id")
    private int transactionId;
    @Column(name = "registration_Id")
    private int registrationId;
    @Column(name = "issue_Date")
    private LocalDateTime issueDate;
    @Column(name = "return_Date")
    private LocalDateTime returnDate;
    @Column
    private double fine;
}
