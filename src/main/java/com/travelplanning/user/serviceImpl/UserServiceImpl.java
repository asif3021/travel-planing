package com.travelplanning.user.serviceImpl;

import com.travelplanning.user.config.UserNotFoundException;
import com.travelplanning.user.model.User;
import com.travelplanning.user.repository.UserRepository;
import com.travelplanning.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser(User user) {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(username);
        }
        return userOptional;
    }
}