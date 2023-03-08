package com.simplilearn.estorezone.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.estorezone.admin.entity.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer>{

	Page<Categories> findByCategoryNameContaining(String title, Pageable pageable);
	
	boolean existsByCategoryName(String categoryName);

}
