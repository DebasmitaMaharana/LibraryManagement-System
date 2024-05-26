package com.boot.lms.LibraryManagement.repository;

import com.boot.lms.LibraryManagement.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmailId(String emailId);
}
