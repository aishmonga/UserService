package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/user")

    public ResponseEntity<User> saveUser(@RequestBody User user){

        User savedUser = userServiceImpl.saveUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.OK);
    }

    @GetMapping("/users")

    public ResponseEntity<List<User>> getAllUsers(){
        List<User> usersList =  userServiceImpl.getALlUsers();
        return new ResponseEntity<List<User>>(usersList , HttpStatus.OK);
    }

    @GetMapping("/user/{id}")

    public ResponseEntity<User> getUserById(@PathVariable int id){
        User userById = userServiceImpl.getUserById(id);
        return new ResponseEntity<User>(userById , HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")

    public ResponseEntity<List<User>> deleteUserById(@PathVariable int id){
        userServiceImpl.deleteById(id);
        return new ResponseEntity<List<User>>(userServiceImpl.getALlUsers() , HttpStatus.OK);
    }

    @PutMapping("user/{id}")

    public ResponseEntity<List<User>> updateUserById(@PathVariable int id ,@RequestBody User user){
         userServiceImpl.updatedUser(user,id);
        return new ResponseEntity<List<User>>(userServiceImpl.getALlUsers() , HttpStatus.OK);
    }

}



