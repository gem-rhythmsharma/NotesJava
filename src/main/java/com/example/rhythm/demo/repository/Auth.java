package com.example.rhythm.demo.repository;

import com.example.rhythm.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Auth extends JpaRepository<User,String> {
}
