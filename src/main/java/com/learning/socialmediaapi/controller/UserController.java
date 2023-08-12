package com.learning.socialmediaapi.controller;

import com.learning.socialmediaapi.entity.User;
import com.learning.socialmediaapi.exceptions.UserNotFoundException;
import com.learning.socialmediaapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @Operation(summary = "get all users", description = "get all users available in the database")
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userService.findAll();
    }
    @Operation(summary = "get user by ID", description = "get first users available by ID")
    @GetMapping("/users/{id}")
    public User retrieveAnUsers(@PathVariable int id){
        User user = userService.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id not found ::"+id);
        return user;
    }
    @Operation(summary = "delete user by ID", description = "delete first users available by ID")
    @DeleteMapping("/users/{id}")
    public void deleteAnUsers(@PathVariable int id){
        userService.deleteById(id);
    }
    @Operation(summary = "Create  user", description = "create  users")
    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody User user){
       User savedUser = userService.saveUser(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
