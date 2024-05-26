package com.boot.lms.LibraryManagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email_id", unique = true, nullable = false)
    private String emailId;
    @Column(name = "librarian", nullable = false)
    private Boolean librarian;
}