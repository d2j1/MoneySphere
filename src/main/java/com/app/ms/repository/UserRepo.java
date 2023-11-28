package com.app.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ms.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
