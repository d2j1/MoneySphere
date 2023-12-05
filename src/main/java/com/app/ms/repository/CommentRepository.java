package com.app.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ms.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
