package com.shiruvaaa.myaniviewj.service;

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
    };

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

}
