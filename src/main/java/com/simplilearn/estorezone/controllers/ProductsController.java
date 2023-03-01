package com.simplilearn.estorezone.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.estorezone.admin.dto.ResponseDto;
import com.simplilearn.estorezone.admin.entity.Products;
import com.simplilearn.estorezone.repository.ProductsRepository;

@RestController("/v1/products")
public class ProductsController {
	
	@Autowired
	ProductsRepository productsRepository;
	
	/**
	 * Get all products or Search product by title like operation.
	 * @param title
	 * @return
	 */
	@GetMapping("")
	public List<Products> getAll(@RequestParam("title") String title) {
		if (title != null && title != "") {
			return productsRepository.findByProductTitleContaining(title);
		}
		return productsRepository.findAll();
	}
	
	/**
	 * Get one product by id
	 * @param productId
	 * @return
	 */
	@GetMapping("/{productId}")
	public Optional<Products> getOne(@RequestParam("id") int productId) {
		return productsRepository.findById(productId);
	}
	
	/**
	 * Save Products.
	 * @param products
	 * @return
	 */
	@PostMapping("")
	public Products save(@RequestBody Products products) {
		return productsRepository.save(products);
	}
	
	/**
	 * Update products
	 * @param products
	 * @return
	 */
	@PutMapping("")
	public Products udpate(@RequestBody Products products) {
		boolean eixts = productsRepository.existsById(products.getProductId());
		if (eixts) {
			return productsRepository.save(products);
		}
		throw new RuntimeException("Product does not exits");
	}
	
	/**
	 * Delete one product by id
	 * @param productId
	 * @return Optional<Products>
	 */
	@DeleteMapping("/{productId}")
	public ResponseDto deleteOne(@RequestParam("id") int productId) {
		boolean exists = productsRepository.existsById(productId);
		if (exists) {
			productsRepository.deleteById(productId);
			return new ResponseDto("Success","Product deleted", new Date(), null);
		}
		throw new RuntimeException("Product does not exits");
	}

}
