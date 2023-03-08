package com.simplilearn.estorezone.service.Imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.simplilearn.estorezone.admin.entity.Products;
import com.simplilearn.estorezone.repository.ProductsRepository;
import com.simplilearn.estorezone.service.ProductsService;

@Service
public class ProductsServiceImp implements ProductsService{

	@Autowired
	ProductsRepository productsRepository;
	
	@Override
	public Page<Products> findByProductTitleContaining(String title, Pageable pageable) {
		return productsRepository.findByProductTitleContaining(title, pageable);
	}

	@Override
	public Page<Products> findAll(Pageable pageable) {
		return productsRepository.findAll(pageable);
	}

	@Override
	public Optional<Products> findById(int productId) {
		return productsRepository.findById(productId);
	}

	@Override
	public Products save(Products products) {
		return productsRepository.save(products);
	}

	@Override
	public boolean existsById(int productId) {
		return productsRepository.existsById(productId);
	}

	@Override
	public void deleteById(int productId) {
		productsRepository.deleteById(productId);
		
	}

}
