package com.rms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rms.dtos.CategoryDTO;
import com.rms.services.CategoryServiceImpl;
import com.rms.utils.ResponseUtil;

@CrossOrigin	
@RestController
@RequestMapping("/categories")
public class CategoryControllerImpl {
	
	@Autowired
	private CategoryServiceImpl serviceImpl;
	
	@GetMapping("")
	public ResponseEntity<?> getAllCategory(){
		return ResponseUtil.success(serviceImpl.getAllCategories());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable("id") Integer id){
		return ResponseUtil.success(serviceImpl.getCategoryById(id));
	}
	@GetMapping("/active")
	public ResponseEntity<?> getCategoryByStatus(){
		return ResponseUtil.success(serviceImpl.getAllCategoriesByStatus());
	}
	@PostMapping("")
	public ResponseEntity<?> addCategory(@RequestBody CategoryDTO categoryDTO){
		return ResponseUtil.success(serviceImpl.addCategory(categoryDTO));
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable("id") Integer id,@RequestBody CategoryDTO categoryDTO){
		return ResponseUtil.success(serviceImpl.updateCategory(id, categoryDTO));	
	}
	@PatchMapping("/{id}")
	public ResponseEntity<?> updateCategoryStatus(@PathVariable("id") Integer id,@RequestBody CategoryDTO categoryDTO){
		return ResponseUtil.success(serviceImpl.updateCategoryStatus(id, categoryDTO));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategoryById(@PathVariable("id") Integer id){
		return ResponseUtil.success(serviceImpl.deleteCategoryById(id));
	}
}
