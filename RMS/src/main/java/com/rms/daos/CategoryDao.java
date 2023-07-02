package com.rms.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.entities.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
	Category findByCategoryId(Integer id);
	List<Category> findByCategoryStatus(String status);
}
