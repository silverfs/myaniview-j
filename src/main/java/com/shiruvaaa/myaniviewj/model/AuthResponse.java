package com.shiruvaaa.myaniviewj.model;

public class AuthResponse {
    int id;
    String username;

    public AuthResponse(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

}
