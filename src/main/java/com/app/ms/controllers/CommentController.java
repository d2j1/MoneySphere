package com.app.ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ms.payloads.ApiResponse;
import com.app.ms.payloads.CommentDto;
import com.app.ms.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
		
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment( @RequestBody CommentDto commentDto, @PathVariable Integer postId){
		
		commentDto= this.commentService.createComment(commentDto, postId);
		
		return new ResponseEntity<CommentDto>( commentDto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
		
		this.commentService.deleteComment(commentId);
		
		return new ResponseEntity<ApiResponse>( new ApiResponse("Comment deleted successfully", true) , HttpStatus.OK);
	}
	
	
	
}
