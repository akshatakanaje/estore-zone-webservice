package com.simplilearn.estorezone.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.estorezone.admin.entity.Products;



@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer>{

	Page<Products> findByProductTitleContaining(String title, Pageable pageable);
	
	Page<Products> findAll(Pageable pageable);

}
