package com.project1.user_management.controllers;

import com.project1.user_management.models.dtos.UserDto;
import com.project1.user_management.services.interfaces.UserInterface;
import com.project1.user_management.utils.handlers.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserInterface userInterface;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserDto user) {
        return ResponseHandler.tryCatchWrapper(() -> userInterface.addUser(user));
    }

    @PutMapping
    public ResponseEntity<?> updatePassword(@RequestParam Long userId, @RequestBody UserDto user) {
        return ResponseHandler.tryCatchWrapper(() -> userInterface.updatePassword(userId, user));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestParam Long userId) {
        return ResponseHandler.tryCatchWrapper(() -> userInterface.deleteUser(userId));
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return ResponseHandler.tryCatchWrapper(()-> userInterface.getUsers());
    }

}
