package com.app.ms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ms.entities.Category;
import com.app.ms.exceptions.ResourceNotFoundException;
import com.app.ms.payloads.CategoryDto;
import com.app.ms.repository.CategoryRepository;
import com.app.ms.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category  ctr = this.modelMapper.map(categoryDto, Category.class);
		ctr = categoryRepo.save(ctr);
		
		categoryDto = this.modelMapper.map(ctr, CategoryDto.class);
		
		return categoryDto;
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer catId) {

		
		Category cat = this.categoryRepo.findById(catId).orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", catId));
				
		cat.setCategoryName(categoryDto.getCategoryName());
		cat.setCategoryDesc(categoryDto.getCategoryDesc());
		
		cat = this.categoryRepo.save(cat);
		
		categoryDto= this.modelMapper.map(cat, CategoryDto.class);
		
		
		return categoryDto;
	}

	@Override
	public void deleteCategory(Integer catId) {
		
		Category cat = this.categoryRepo.findById(catId).orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", catId));
		this.categoryRepo.delete(cat);
	}

	@Override
	public CategoryDto getCategory(Integer catId) {

		Category cat = this.categoryRepo.findById(catId).orElseThrow(() -> new ResourceNotFoundException("Category", "category Id", catId));
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}
	
	@Override
	public List<CategoryDto> getCategories() {

		List<Category> cat = this.categoryRepo.findAll();
		List<CategoryDto> categoryDtos = cat.stream().map( category ->  this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		
		return categoryDtos;
	}

	

}
