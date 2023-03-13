package com.simplilearn.estorezone.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.simplilearn.estorezone.enduser.entity.Carts;


public interface CartsRepository extends JpaRepository<Carts, Integer>{

	boolean existsBycartId(int cartId);

	Page<Carts> findByUserId(int userId, Pageable pageable);

	

}
