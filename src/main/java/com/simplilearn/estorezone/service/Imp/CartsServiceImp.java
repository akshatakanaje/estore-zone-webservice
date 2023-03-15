package com.simplilearn.estorezone.service.Imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.simplilearn.estorezone.admin.entity.Products;
import com.simplilearn.estorezone.enduser.entity.Carts;
import com.simplilearn.estorezone.repository.CartsRepository;
import com.simplilearn.estorezone.repository.ProductsRepository;
import com.simplilearn.estorezone.service.CartsService;

@Service
public class CartsServiceImp implements CartsService{
	
	@Autowired
	CartsRepository cartsRepository;
	
	@Autowired
	ProductsRepository productsRepository;

	@Override
	public Page<Carts> findAll(Pageable pageable) {
		return cartsRepository.findAll(pageable);
	}

	@Override
	public Optional<Carts> findById(int id) {
		return cartsRepository.findById(id);
	}

	@Override
	public boolean existsById(int cartId) {
		return cartsRepository.existsById(cartId);
	}

	@Override
	public Carts save(Carts carts) {
		return cartsRepository.save(carts);
	}

	@Override
	public void deleteById(int cartId) {
		cartsRepository.deleteById(cartId);
	}
	
	
	@Override
	public Page<Carts> fingByUserId(int userId, Pageable pageable) {
		Page<Carts> carts = cartsRepository.findByUserId(userId, pageable);
		for (Carts cart : carts.getContent()) {
			Optional<Products> optional = productsRepository.findById(cart.getProductId());
			Products product = optional.get();
			cart.setProducts(product);
		}
		return carts;
	}

}
