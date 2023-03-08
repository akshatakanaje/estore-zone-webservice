package com.simplilearn.estorezone.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.estorezone.admin.entity.Orders;



@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

	Page<Orders> findByOrderStatusContaining(String status, Pageable pageable);

	boolean existsByOrderStatus(String orderStatus);
	
	

}
