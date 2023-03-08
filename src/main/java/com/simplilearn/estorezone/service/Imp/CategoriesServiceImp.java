package com.simplilearn.estorezone.service.Imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.simplilearn.estorezone.admin.entity.Categories;
import com.simplilearn.estorezone.repository.CategoriesRepository;
import com.simplilearn.estorezone.service.CategoriesService;

@Service
public class CategoriesServiceImp implements CategoriesService{

	@Autowired
    CategoriesRepository categoriesRepository;
	
	@Override
	public Page<Categories> findByCategoryNameContaining(String title, Pageable pageable) {		
		return categoriesRepository.findByCategoryNameContaining(title, pageable);
	}

	@Override
	public Page<Categories> findAll(Pageable pageable) {
		return categoriesRepository.findAll(pageable);
	}

	@Override
	public Optional<Categories> findById(int id) {
		return categoriesRepository.findById(id);
	}

	@Override
	public boolean existsByCategoryName(String categoryName) {
		return categoriesRepository.existsByCategoryName(categoryName);
	}

	@Override
	public Categories save(Categories categories) {
		return categoriesRepository.save(categories);
	}

	@Override
	public boolean existsById(int id) {
		return categoriesRepository.existsById(id);
	}

	@Override
	public void deleteById(int id) {
		categoriesRepository.deleteById(id);		
	}

}
