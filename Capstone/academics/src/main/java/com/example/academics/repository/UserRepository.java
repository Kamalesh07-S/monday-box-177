package com.example.academics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.academics.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
