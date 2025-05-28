package com.userService.UserService.controller;

import com.userService.UserService.model.User;
import com.userService.UserService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser = this.userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String userId){
        User userById = this.userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(userById);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getUsers(){
        List<User> allUser = this.userService.getAllUser();
        if(allUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Users not found");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(allUser);
        }
    }
}