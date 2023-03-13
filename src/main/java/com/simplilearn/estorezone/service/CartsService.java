package com.simplilearn.estorezone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.simplilearn.estorezone.enduser.entity.Carts;

public interface CartsService {

	
	Page<Carts> findAll(Pageable pageable);

	Optional<Carts> findById(int id);

	boolean existsById(int cartId);

	Carts save(Carts carts);

	void deleteById(int cartId);

	Page<Carts> fingByUserId(int userId, Pageable pageable);

}
