package com.simplilearn.estorezone.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.estorezone.admin.entity.Products;

public interface ProductsService {

	List<Products> findByProductTitleContaining(String title);

	List<Products> findAll();

	Optional<Products> findById(int productId);

	Products save(Products products);

	boolean existsById(int productId);

	void deleteById(int productId);

}
