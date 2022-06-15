package com.shiruvaaa.myaniviewj.service;

import com.shiruvaaa.myaniviewj.model.AuthResponse;
import com.shiruvaaa.myaniviewj.model.Authentication;
import com.shiruvaaa.myaniviewj.model.User;
import com.shiruvaaa.myaniviewj.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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

    @Transactional
    public void updateUser(int id, String username, String password, String anilistname) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("user with id: " + id + " not found!"));
        if(username != null &&
                username.length() > 0 &&
                !Objects.equals(user.getUsername(), username)) {
            user.setUsername(username);
        }
        if(password != null &&
                password.length() > 0 &&
                !Objects.equals(user.getPassword(), password)) {
            user.setPassword(password);
        }
        if(anilistname != null &&
                !Objects.equals(user.getAnilistname(), anilistname)) {
            user.setAnilistname(anilistname);
        }
    }
}
