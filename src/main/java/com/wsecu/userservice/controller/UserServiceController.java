package com.wsecu.userservice.controller;

import com.wsecu.userservice.data.UserServiceRepository;
import com.wsecu.userservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.List;

@RestController
public class UserServiceController {
    //Initialize data repository
    @Autowired
    private final UserServiceRepository repository;
    UserServiceController(UserServiceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public List<User> index() {
        return repository.findAll();
    }

    @PostMapping(value = "/add-user")
    public void addUser(@RequestBody User newUser) {
        repository.save(newUser);
    }

    @DeleteMapping(value = "/remove-user/{id}")
    public void removeUser(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping(value = "/edit-username/{id}/{newUsername}")
    public ResponseEntity<User> editUserName(@PathVariable Long id, @PathVariable String newUsername) {
        repository.setUsernameById(newUsername, id);
        User user = repository.findByUserName(newUsername);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping(value = "/edit-email/{id}/{newEmail}")
    public ResponseEntity<User> editUserEmail(@PathVariable Long id, @PathVariable String newEmail) {
        boolean valid = EmailValidator.getInstance(true).isValid(newEmail);
        if(valid) {
            repository.setUserEmailById(newEmail, id);
            User user = repository.findByEmail(newEmail);

            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/get-user/{email}")
    public ResponseEntity<User> getUserName(@PathVariable String email) {
        User user = repository.findByEmail(email);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
