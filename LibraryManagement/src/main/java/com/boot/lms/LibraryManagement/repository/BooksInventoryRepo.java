package com.boot.lms.LibraryManagement.repository;

import com.boot.lms.LibraryManagement.entity.BooksInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksInventoryRepo extends JpaRepository<BooksInventory, Integer> {
}
