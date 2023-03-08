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
import com.simplilearn.estorezone.admin.entity.Products;
import com.simplilearn.estorezone.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	ProductsService productsService;
	
	/**
	 * Get all products or Search product by title like operation.
	 * @param title
	 * @return
	 */
	@GetMapping
	public List<Products> getAll(@RequestParam(value="title", required=false) String title) {
		if (title != null && title != "") {
			return productsService.findByProductTitleContaining(title);
		}
		return productsService.findAll();
	}
	
	/**
	 * Get one product by id
	 * @param productId
	 * @return
	 */
	@GetMapping("/{productId}")
	public Optional<Products> getOne(@PathVariable("productId") int productId) {
		return productsService.findById(productId);
	}
	
	/**
	 * Save Products.
	 * @param products
	 * @return
	 */
	@PostMapping
	public Products save(@RequestBody Products products) {
		return productsService.save(products);
	}
	
	/**
	 * Update products
	 * @param products
	 * @return
	 */
	@PutMapping
	public Products udpate(@RequestBody Products products) {
		boolean exists = productsService.existsById(products.getProductId());
		if (exists) {
			return productsService.save(products);
		} 
		throw new RuntimeException("Product does not exits");
	}
	
	/**
	 * Delete one product by id
	 * @param productId
	 * @return Optional<Products>
	 */
	@DeleteMapping("/{productId}")
	public ResponseDto deleteOne(@PathVariable("productId") int productId) {
		boolean exists = productsService.existsById(productId);
		if (exists) {
			productsService.deleteById(productId);
			return new ResponseDto("Success","Product deleted", new Date(), null);
		}
		throw new RuntimeException("Product does not exits");
	}
}
