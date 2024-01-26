package com.travelplanning.user.controller;

import com.travelplanning.user.config.UserNotFoundException;
import com.travelplanning.user.model.User;
import com.travelplanning.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveNewUser(user));
    }

//    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    @RequestMapping(value = "/get-all")
    public ResponseEntity<List<User>> getAllUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.getAllUser(user));
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        try {
            Optional<User> userOptional = userService.getUserByUsername(username);
            return ResponseEntity.ok(userOptional.get());
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
