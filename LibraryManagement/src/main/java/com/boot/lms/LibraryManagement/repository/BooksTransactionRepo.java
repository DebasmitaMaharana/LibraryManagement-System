package com.boot.lms.LibraryManagement.repository;

import com.boot.lms.LibraryManagement.entity.BooksTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksTransactionRepo extends JpaRepository<BooksTransaction, Integer> {

}
