package com.app.ms.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.ms.entities.Category;
import com.app.ms.entities.Post;
import com.app.ms.entities.User;
import com.app.ms.exceptions.ResourceNotFoundException;
import com.app.ms.payloads.PostDto;
import com.app.ms.repository.CategoryRepository;
import com.app.ms.repository.PostRepo;
import com.app.ms.repository.UserRepo;
import com.app.ms.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CategoryRepository catRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		
		User user = userRepo.findById(userId).orElseThrow( () -> new ResourceNotFoundException("User","Id", userId));
		Category category = catRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("CAtegory","Id", categoryId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		post = this.postRepo.save(post);
		
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post","Id", postId));
		
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		
		
		post = this.postRepo.save(post);

		
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {

		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post","Id", postId));
		
		this.postRepo.delete(post);
	}

	@Override
	public List<PostDto> getAllPost() {

		List<Post> posts = this.postRepo.findAll();
		
		List<PostDto> postDtos = posts.stream().map( post ->  this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId ));
		
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		
		Category cat = this.catRepo.findById(categoryId).orElseThrow( () -> new ResourceNotFoundException("Category", "Id", categoryId));
		
		List<Post> posts = this.postRepo.findByCategory(cat);
		
		List<PostDto> postDtos = posts.stream().map( post -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		
		return postDtos;
	}

	@Override
	public List<PostDto> getAllPostByUser(Integer UserId) {

		User user = this.userRepo.findById(UserId).orElseThrow( () -> new ResourceNotFoundException("User", "Id", UserId));
		
		List<Post> posts = this.postRepo.findByUser(user);
		
		List<PostDto> postDtos = posts.stream().map( post -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
				
		return postDtos;
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
