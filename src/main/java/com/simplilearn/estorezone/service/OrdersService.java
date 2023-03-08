package com.simplilearn.estorezone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.simplilearn.estorezone.admin.entity.Orders;

public interface OrdersService {

	Page<Orders> findByOrderStatusContaining(String status, Pageable pageable);

	Page<Orders> findAll(Pageable pageable);

	Optional<Orders> findById(int orderId);

	boolean existsByOrderStatus(String orderStatus);

	Orders save(Orders orders);

	boolean existsById(int orderId);

	void deleteById(int orderId);

}
