package com.example.rhythm.demo.Controller;

import com.example.rhythm.demo.Model.Note;
import com.example.rhythm.demo.Service.NoteService;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
//@RequestMapping("/updateNote")   => This is for multiple controllers and you can divide them in seprate categories
public class HelloControler {
    @Autowired
    NoteService noteService;


    @GetMapping("/hello")
//    @ContentType("text/plain")
    public static String welcome(){
        return "Welcome to SpringBoot project";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addNewNote")
    public  Note addNewNote(@RequestBody Note note){
        return noteService.addNote(note);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Note> deleteNote(@PathVariable int id){
        return noteService.deleteNote(id);
    }

    @PostMapping("/update/{id}")
    public static ResponseEntity<Note> updateNote(@PathVariable int id, @RequestBody Note note ){
        return NoteService.updateNote(id,note);
    }

    @GetMapping("/getALlNotes")
    public  ResponseEntity<ArrayList<Note>> getAllNotes(){
        return noteService.getAllNote();
    }
}
