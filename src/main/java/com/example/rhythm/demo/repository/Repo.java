package com.example.rhythm.demo.repository;

import com.example.rhythm.demo.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Repo extends JpaRepository<Note,Integer> {
}
