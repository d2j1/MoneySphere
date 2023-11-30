package com.app.ms.service;

import java.util.List;

import com.app.ms.payloads.CategoryDto;

public interface CategoryService {

	
	// create
	 CategoryDto createCategory(CategoryDto categoryDto);
	
	// update 
	 CategoryDto updateCategory( CategoryDto categoryDto, Integer catId );
	
	// delete 
	 void deleteCategory( Integer catId);
	
	// get
	 CategoryDto getCategory( Integer catId);
	 
	// get all
	 List<CategoryDto> getCategories();
		
	
}
