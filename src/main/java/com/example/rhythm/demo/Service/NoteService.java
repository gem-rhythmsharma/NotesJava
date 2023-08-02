package com.example.rhythm.demo.Service;

import com.example.rhythm.demo.Dao.NoteDao;
import com.example.rhythm.demo.Model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Service
public class NoteService {
    @Autowired
    NoteDao noteDao;
    public Note[] allNote=new Note[10];
    private static ArrayList<Note> list=new ArrayList<Note>();

    public Note addNote(Note note){
        list.add(note);
//        noteDao.;
        return note;
    }
    public ResponseEntity<Note> deleteNote(int id){
        int index=-1;
        for(int i=0;i<list.size();i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
            }
            break;
        }
        return new ResponseEntity("Note Deleted",HttpStatus.OK);
    }

    public static ResponseEntity<Note> updateNote(int id, Note note){
        int index=-1;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==id){
                index=i;
                list.set(i,note);
            }
        }
        if(index==-1) {
            return new ResponseEntity("Empty note",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(list.get(index),HttpStatus.OK) ;
    }


    public ResponseEntity<ArrayList<Note>> getAllNote() {

        System.out.println(noteDao.findAll());
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
