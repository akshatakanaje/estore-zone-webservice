package com.simplilearn.estorezone.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.estorezone.admin.entity.Categories;

public interface CategoriesService {

	List<Categories> findByCategoryNameContaining(String title);

	List<Categories> findAll();

	Optional<Categories> findById(int id);

	boolean existsByCategoryName(String categoryName);

	Categories save(Categories categories);

	boolean existsById(int id);

	void deleteById(int id);

}
