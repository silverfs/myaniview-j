package com.shiruvaaa.myaniviewj.repository;

import com.shiruvaaa.myaniviewj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT `id` FROM `users` WHERE `username` = ?1 AND `password` = ?2", nativeQuery = true)
    int login(String username, String password);
}
