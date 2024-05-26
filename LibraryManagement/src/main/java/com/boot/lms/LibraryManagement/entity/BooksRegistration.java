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
public class BooksRegistration {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registrationId;
    @Column
    private String bookId;
    @Column
    private String userId;
    @Column
    private LocalDateTime registrationDate;

}
