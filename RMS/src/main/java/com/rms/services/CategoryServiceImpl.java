package com.rms.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.daos.CategoryDao;
import com.rms.dtos.CategoryDTO;
import com.rms.entities.Category;
import com.rms.utils.DtoEntityConverter;
@Service
public class CategoryServiceImpl {
	
	@Autowired
	private CategoryDao catDao;
	@Autowired
	private DtoEntityConverter converter;
	
	public Map<String, Object> addCategory(CategoryDTO categoryDTO){
		Category category = catDao.save(converter.toCategoryEntity(categoryDTO));
		return Collections.singletonMap("insertedId", category.getCategoryId());
	}
	
	public Map<String ,Object> updateCategory(Integer id, CategoryDTO categoryDTO){
		Category category = catDao.findByCategoryId(id);
		category.setCategoryName(categoryDTO.getCategoryName());
		category = catDao.save(category);
		return Collections.singletonMap("updatedId", category.getCategoryId());
	}
	
	public  Map<String, Object> updateCategoryStatus(int id,CategoryDTO categoryDto)
	{
		Category category = catDao.findByCategoryId(id);
		category.setCategoryStatus(categoryDto.getCategoryStatus());
		category=	catDao.save(category);
		return  Collections.singletonMap("UpdatedId",category.getCategoryId());
	}
	
	public List<CategoryDTO> getAllCategories(){
		List<CategoryDTO> list = new ArrayList<CategoryDTO>();
		List<Category> catList = catDao.findAll();
		for(Category category : catList) {
			list.add(converter.toCategoryDTO(category));
		}

		return list;
	}
	
	public List<CategoryDTO> getAllCategoriesByStatus(){
		List<CategoryDTO> list = new ArrayList<CategoryDTO>();
		List<Category> catList = catDao.findByCategoryStatus("Enabled");
		for(Category category : catList) {
			list.add(converter.toCategoryDTO(category));
		}
		return list;
	}
	
	public CategoryDTO getCategoryById(Integer id) {
		Category category = catDao.findByCategoryId(id);
		return converter.toCategoryDTO(category);
	}

	public Integer deleteCategoryById(Integer id)
	{
		if(catDao.existsById(id))
		{
			catDao.deleteById(id);
			return 1;
		}	
		return 0;
	}
}
