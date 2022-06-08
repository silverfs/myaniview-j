package com.shiruvaaa.myaniviewj.repository;

import com.shiruvaaa.myaniviewj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
