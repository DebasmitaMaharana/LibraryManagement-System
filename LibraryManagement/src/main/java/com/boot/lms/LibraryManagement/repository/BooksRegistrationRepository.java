package com.boot.lms.LibraryManagement.repository;

import com.boot.lms.LibraryManagement.entity.BooksRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRegistrationRepository extends JpaRepository<BooksRegistration, Integer> {
}
