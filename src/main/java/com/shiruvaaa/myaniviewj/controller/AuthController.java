package com.shiruvaaa.myaniviewj.controller;

import com.shiruvaaa.myaniviewj.model.AuthResponse;
import com.shiruvaaa.myaniviewj.model.Authentication;
import com.shiruvaaa.myaniviewj.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Authentication authentication) {
        AuthResponse response = userService.login(authentication);
        return ResponseEntity.status(HttpStatus.OK).body(
            "{" +
                " \"id\": " + response.getId() + "," +
                " \"username\": " + response.getUsername() +
            " }");
    }
}
