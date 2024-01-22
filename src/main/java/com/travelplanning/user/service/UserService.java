package com.travelplanning.user.service;

import com.travelplanning.user.config.UserNotFoundException;
import com.travelplanning.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User saveNewUser(User user);
    public List<User> getAllUser(User user);
    public Optional<User> getUserByUsername(String username) throws UserNotFoundException;
}