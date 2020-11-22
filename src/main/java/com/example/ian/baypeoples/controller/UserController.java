package com.example.ian.baypeoples.controller;

import com.example.ian.baypeoples.exception.UserNotFoundException;
import com.example.ian.baypeoples.model.User;
import com.example.ian.baypeoples.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        try {
            User createdUser = userRepository.save(user);
            HttpHeaders headers = new HttpHeaders();
            headers.add("id", createdUser.getUserId().toString());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) throws UserNotFoundException {
        try {
            Optional<User> user = userRepository.findById(Long.valueOf(id));
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        } catch (Exception e) {
            throw new UserNotFoundException("User not found!!!!!!");
        }
    }
}
