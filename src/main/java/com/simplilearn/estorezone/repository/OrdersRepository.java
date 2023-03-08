package com.simplilearn.estorezone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.estorezone.admin.entity.Orders;



@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

	List<Orders> findByOrderStatusContaining(String status);

	boolean existsByOrderStatus(String orderStatus);
	
	

}
