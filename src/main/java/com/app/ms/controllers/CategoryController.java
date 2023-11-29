package com.app.ms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ms.payloads.ApiResponse;
import com.app.ms.payloads.CategoryDto;
import com.app.ms.service.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl catService;
	
	
//	create 
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCat(@RequestBody CategoryDto cat){
		
		cat = catService.createCategory(cat);
		return new ResponseEntity<CategoryDto>(cat, HttpStatus.CREATED) ;
	}
	
//	update
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCat(@RequestBody CategoryDto cat, @PathVariable Integer catId){
		
		cat = this.catService.updateCategory(cat, catId);
		
		return new ResponseEntity<CategoryDto>(cat, HttpStatus.CREATED);
	}
	
//	 delete
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCat(@PathVariable Integer catId){
		
		this.catService.deleteCategory(catId);
		
		return new ResponseEntity<>(new ApiResponse("Category delete successfully", true), HttpStatus.OK);
	}
	
	
//	get
	
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCat(@PathVariable Integer catId){
		
		CategoryDto catDto = this.catService.getCategory(catId);
		
		return new ResponseEntity<>(  catDto, HttpStatus.OK);
	}
	
	
//	get All 
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCat(){
		
		List<CategoryDto> catDtos = this.catService.getCategories();
				
		return new ResponseEntity<>(catDtos, HttpStatus.OK);
	}
}
