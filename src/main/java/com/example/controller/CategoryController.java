package com.example.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Category;
import com.example.repository.CategoryRepository;

@RestController 
@RequestMapping("/api")
public class CategoryController {

	private CategoryRepository categoryRepository; 

	public CategoryController(CategoryRepository categoryRepository) {
		super(); 
		this.categoryRepository = categoryRepository;
	} 
	
	@GetMapping("/categories")
	Collection<Category> categories(){
		return categoryRepository.findAll(); 
		//select * from category
	} 
	
	//category 2 
	//returns the category, if it's empty, then it returns nothing because of an invalid id, the reason for using optional 
	//return the results from the category and maps it to response, if it's ok, put the response in the body and send it back to the browser
	@GetMapping("/category/{id}") 
	ResponseEntity<?> getCategory(@PathVariable Long id){
		Optional<Category> category = categoryRepository.findById(id);  
		return category.map(response->ResponseEntity.ok().body(response)).
		orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	} 
	
	
	//receives a path and save, then return to the category we just saved. craft the URL to gain specific access to specified category 
	@PostMapping("/category")
	ResponseEntity<Category> createCategory(@Valid @RequestBody Category category ) throws URISyntaxException{ 
		Category result = categoryRepository.save(category); 
		return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result); 
	} 
	
	@PostMapping("/category/{id}") 
	ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category){
		Category result= categoryRepository.save(category); 
		return ResponseEntity.ok().body(result);
	}

}
