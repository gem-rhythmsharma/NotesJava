package com.example.rhythm.demo.Service;

import com.example.rhythm.demo.Model.User;
import com.example.rhythm.demo.repository.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    Auth userDao;

    public ResponseEntity<User> loginAuth(User user){
        try{
            if(userDao.existsById(user.getEmail())){

                Optional<User> temp=userDao.findById(user.getEmail());
                System.out.print(temp+" "+user);
                return new ResponseEntity("Login Successful", HttpStatus.OK);
            }
        }
        catch (Exception e){
            return new ResponseEntity("Login Successful", HttpStatus.OK);
        }
        userDao.findById(user.getEmail());
        return new ResponseEntity("Login Successful", HttpStatus.OK);
    }

    public ResponseEntity<User> registerUser(User user){
        try{
            if(userDao.existsById(user.getEmail())){
                return new ResponseEntity("Already user Created",HttpStatus.FORBIDDEN);
            }
            userDao.save(user);
            return new ResponseEntity(user,HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }


    }


}
