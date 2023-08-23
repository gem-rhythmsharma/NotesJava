package com.example.rhythm.demo.Controller;

import com.example.rhythm.demo.Model.Note;
import com.example.rhythm.demo.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/updateNote")   => This is for multiple controllers and you can divide them in seprate categories
public class NotesControler {
    @Autowired
    NoteService noteService;


    @GetMapping("/hello")
//    @ContentType("text/plain")
    public static String welcome(){
        return "Welcome to SpringBoot project";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addNewNote")
    public  ResponseEntity<Note> addNewNote(@RequestBody Note note){
        return noteService.addNote(note);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Note> deleteNote(@PathVariable int id){
        return noteService.deleteNote(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/update/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable int id, @RequestBody Note note ){
        return noteService.updateNote(id,note);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getALlNotes")
    public  ResponseEntity<List<Note>> getAllNotes(){
        return noteService.getAllNote();
    }
}
