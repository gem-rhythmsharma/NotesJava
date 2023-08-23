package com.example.rhythm.demo.Controller;


import com.example.rhythm.demo.Model.User;
import com.example.rhythm.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        return  userService.loginAuth(user);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody User user){
        return userService.registerUser(user);
    }


}
