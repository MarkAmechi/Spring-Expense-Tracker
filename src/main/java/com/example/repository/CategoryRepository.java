package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Category;

//Connects Category to a database, Java object is being mapped to a database table
public interface CategoryRepository extends JpaRepository<Category, Long> {
	//find by + field, this is how we search the table.
	Category findByName(String name);
}
