package com.app.ms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ms.payloads.PostDto;
import com.app.ms.service.PostService;


@RestController
@RequestMapping
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost( @RequestBody PostDto postDto,
			@PathVariable("userId") Integer userId, @PathVariable("categoryId") Integer categoryId) {
		
		postDto = postService.createPost(postDto, userId, categoryId);
				
		return new ResponseEntity<PostDto>(postDto, HttpStatus.CREATED);
	}
	
	// get by user id
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPost(@PathVariable Integer userId){
	
		List<PostDto> postDtos= this.postService.getAllPostByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.ACCEPTED);	
	}
	
	// get by category 
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
	
		List<PostDto> postDtos= this.postService.getPostsByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.ACCEPTED);	
	}
}
