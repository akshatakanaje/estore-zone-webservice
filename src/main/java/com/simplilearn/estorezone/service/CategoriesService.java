package com.simplilearn.estorezone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.simplilearn.estorezone.admin.entity.Categories;

public interface CategoriesService {

	Page<Categories> findByCategoryNameContaining(String title, Pageable pageable);

	Page<Categories> findAll(Pageable pageable);

	Optional<Categories> findById(int id);

	boolean existsByCategoryName(String categoryName);

	Categories save(Categories categories);

	boolean existsById(int id);

	void deleteById(int id);

}
