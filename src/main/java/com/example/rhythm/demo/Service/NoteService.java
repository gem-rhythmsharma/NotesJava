package com.example.rhythm.demo.Service;

import com.example.rhythm.demo.repository.Repo;
import com.example.rhythm.demo.Model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    Repo noteDao;

    public ResponseEntity<Note> addNote(Note note){
        try{
            noteDao.save(note);
            return new ResponseEntity<>(note, HttpStatus.CREATED);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity("Bad Request",HttpStatus.BAD_REQUEST);

    }
    public ResponseEntity<Note> deleteNote(int id){
        try{
            HashMap newResponse = new HashMap();
            newResponse.put("message", "Note Deleted" );
            noteDao.deleteById(id);
            return new ResponseEntity(newResponse,HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity("Bad Request",HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<Note> updateNote(int id, Note note){
        try{
            note.setId(id);
            noteDao.save(note);
            return new ResponseEntity(noteDao.findById(id) ,HttpStatus.OK) ;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity("Bad Request",HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<List<Note>> getAllNote() {
        try{
            return new ResponseEntity<>(noteDao.findAll(),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity("Bad Request",HttpStatus.BAD_REQUEST);

    }
}
