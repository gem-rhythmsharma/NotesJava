package com.example.rhythm.demo.Dao;

import com.example.rhythm.demo.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDao extends JpaRepository<Note, Integer> {
}
