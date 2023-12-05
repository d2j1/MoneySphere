package com.app.ms.service;

import com.app.ms.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment( CommentDto commentDto, Integer postId);
	
	void deleteComment(Integer commentId);
}
