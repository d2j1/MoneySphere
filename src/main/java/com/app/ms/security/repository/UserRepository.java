package com.app.ms.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ms.security.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
