package com.simplilearn.estorezone.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.estorezone.admin.entity.Categories;
import com.simplilearn.estorezone.repository.CategoriesRepository;
import com.simplilearn.estorezone.service.CategoriesService;

@Service
public class CategoriesServiceImp implements CategoriesService{

	@Autowired
    CategoriesRepository categoriesRepository;
	
	@Override
	public List<Categories> findByCategoryNameContaining(String title) {		
		return categoriesRepository.findByCategoryNameContaining(title);
	}

	@Override
	public List<Categories> findAll() {
		return categoriesRepository.findAll();
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
