package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    public User addUser(User user) {
        return userRepository.save(null != user ? user : new User());
    }

    public User getUserBydId(Long userId) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            return user;
        }
        throw new RuntimeException("User not found with id " + userId);
    }

    public User updateUser(Long userId, User userDetails) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
          User user = existingUser.get();
          user.setFirstName(userDetails.getFirstName());
          user.setLastName(userDetails.getLastName());
          user.setEmail(userDetails.getEmail());
          return userRepository.save(user);
        }
        throw new RuntimeException("User not found with id: " + userId);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
