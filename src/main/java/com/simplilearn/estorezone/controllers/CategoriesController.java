package com.simplilearn.estorezone.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.estorezone.admin.dto.ResponseDto;
import com.simplilearn.estorezone.admin.entity.Categories;
import com.simplilearn.estorezone.exceptions.AlreadyExistException;
import com.simplilearn.estorezone.exceptions.NotFoundException;
import com.simplilearn.estorezone.service.CategoriesService;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
	
	@Autowired
	CategoriesService categoriesService;
	
	/**
	 * Get all categories or Search categories by name like operation.
	 * @param name
	 * @return
	 */
	@GetMapping
	public List<Categories> getAll(@RequestParam(value="title", required=false) String title){
		if(title != null && title != "") {
			return  categoriesService.findByCategoryNameContaining(title);
		}
		return  categoriesService.findAll();
	}
	
	/**
	 * Get one categories by id
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Optional<Categories> getOne(@PathVariable("id") int id){
		Optional<Categories> category = categoriesService.findById(id);
		if(category.isPresent()) {
			return category;
		}
		throw new NotFoundException("Category does not exist with id '"+ id +"'");
	}
	
	/**
	 * Save categories.
	 * @param categories
	 * @return
	 */
	@PostMapping
	public Categories save(@RequestBody Categories categories) {
		boolean exists =  categoriesService.existsByCategoryName(categories.getCategoryName());
		if(!exists) {
			return  categoriesService.save(categories);
		}
		throw new AlreadyExistException("Category already exist with name '"+ categories.getCategoryName() +"'");
	}
	
	/**
	 * Update Categories
	 * @param Categories
	 * @return
	 */
	@PutMapping
	public Categories update(@RequestBody Categories categories) {
		boolean exists =  categoriesService.existsByCategoryName(categories.getCategoryName());
		if(exists) {
			return categoriesService.save(categories);
		}
		throw new NotFoundException("Category does not exist with id '"+ categories.getCategoryId() +"'");
	}
	
	/**
	 * Delete one product by id
	 * @param productId
	 * @return Optional<Products>
	 */
	@DeleteMapping("/{id}")
	public ResponseDto delete(@PathVariable("id") int id) {
		boolean exists =  categoriesService.existsById(id);
		if(exists) {
			 categoriesService.deleteById(id);
			return new ResponseDto("Success","Categories deleted", new Date(), null);
		}
		throw new NotFoundException("Category does exist with id '"+ id +"'");
	}
}
