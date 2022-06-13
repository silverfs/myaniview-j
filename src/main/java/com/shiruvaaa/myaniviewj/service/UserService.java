package com.shiruvaaa.myaniviewj.service;

import com.shiruvaaa.myaniviewj.model.AuthResponse;
import com.shiruvaaa.myaniviewj.model.Authentication;
import com.shiruvaaa.myaniviewj.model.User;
import com.shiruvaaa.myaniviewj.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public AuthResponse login(Authentication authentication){
        int user = userRepository.login(authentication.getUsername(), authentication.getPassword());
        if (user != 0) {
            User userdata = userRepository.getById(user);
            AuthResponse authResponse = new AuthResponse(userdata.getId(), userdata.getUsername());
            return authResponse;
        } else {
            return null;
        }
    }
}
