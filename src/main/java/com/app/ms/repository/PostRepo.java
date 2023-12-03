package com.app.ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ms.entities.Category;
import com.app.ms.entities.Post;
import com.app.ms.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);

}
