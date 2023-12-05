package com.app.ms.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ms.entities.Comment;
import com.app.ms.entities.Post;
import com.app.ms.exceptions.ResourceNotFoundException;
import com.app.ms.payloads.CommentDto;
import com.app.ms.payloads.PostDto;
import com.app.ms.repository.CommentRepository;
import com.app.ms.repository.PostRepo;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {


		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));
		
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		
		comment.setPost(post);
		
		comment = this.commentRepo.save(comment);
		
		return this.modelMapper.map(comment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {

		Comment comment = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
		
		this.commentRepo.delete(comment);
		
		
	}

	
}
