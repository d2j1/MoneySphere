package com.app.ms.service;

import java.util.List;

import com.app.ms.entities.Post;
import com.app.ms.payloads.PostDto;
import com.app.ms.payloads.PostResponse;

public interface PostService {

	
	// create 
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	// update 
	
	PostDto updatePost( PostDto postDto, Integer postId);
	
	// delete 
	void deletePost(Integer postId);
	
	// get all post
	
	PostResponse getAllPost(Integer pageNo, Integer pageSize, String sortBy, String sortDir);
	
	// get by one post by id
	PostDto getPostById(Integer postId);
	
	// get all post by category
	
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	// get all posts by user
	List<PostDto> getAllPostByUser(Integer UserId);
	
	// search posts 
	List<PostDto> searchPosts( String keyword);
	
	
}
