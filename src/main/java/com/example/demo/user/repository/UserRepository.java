package com.example.demo.user.repository;

import com.example.demo.user.etity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByUsername(String Username);
}
