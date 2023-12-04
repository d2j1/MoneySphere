package com.app.ms.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.ms.config.AppConstants;
import com.app.ms.payloads.ApiResponse;
import com.app.ms.payloads.PostDto;
import com.app.ms.payloads.PostResponse;
import com.app.ms.service.FileService;
import com.app.ms.service.PostService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private FileService fileService;

	@Value("${project.image}")
	private String path;

	// create users
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable("userId") Integer userId,
			@PathVariable("categoryId") Integer categoryId) {

		postDto = postService.createPost(postDto, userId, categoryId);

		return new ResponseEntity<PostDto>(postDto, HttpStatus.CREATED);
	}

	// get by user id
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPost(@PathVariable Integer userId) {

		List<PostDto> postDtos = this.postService.getAllPostByUser(userId);

		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.ACCEPTED);
	}

	// get by category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId) {

		List<PostDto> postDtos = this.postService.getPostsByCategory(categoryId);

		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.ACCEPTED);
	}

	// get all posts
	@GetMapping("/allPosts")
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {

		PostResponse postRes = this.postService.getAllPost(pageNo, pageSize, sortBy, sortDir);

		return new ResponseEntity<PostResponse>(postRes, HttpStatus.ACCEPTED);
	}

	// get post by id

	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {

		PostDto postDto = this.postService.getPostById(postId);

		return new ResponseEntity<PostDto>(postDto, HttpStatus.ACCEPTED);
	}

	// delete post by id
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<ApiResponse> deletePostById(@PathVariable Integer postId) {

		this.postService.deletePost(postId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Post is deleted successfully", true),
				HttpStatus.ACCEPTED);
	}

	// updating post

	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {

		postDto = this.postService.updatePost(postDto, postId);

		return new ResponseEntity<PostDto>(postDto, HttpStatus.ACCEPTED);
	}

	// searching
	@GetMapping("/posts/search/{keywrods}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable(value = "keywrods") String keywords) {

		List<PostDto> result = this.postService.searchPosts(keywords);

		return new ResponseEntity<List<PostDto>>(result, HttpStatus.ACCEPTED);
	}

	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadPostImage(@RequestParam("image") MultipartFile image,
			@PathVariable Integer postId) throws IOException {

		PostDto postDto = this.postService.getPostById(postId);

		String fileName = this.fileService.uploadImage(path, image);

		postDto.setImageName(fileName);

		postDto = this.postService.updatePost(postDto, postId);

		return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
	}

	@GetMapping(value = "/post/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response

	) throws IOException {

		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);

		StreamUtils.copy(resource, response.getOutputStream());
	}

}

