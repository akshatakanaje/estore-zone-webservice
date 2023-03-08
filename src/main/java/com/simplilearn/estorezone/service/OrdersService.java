package com.simplilearn.estorezone.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.estorezone.admin.entity.Orders;

public interface OrdersService {

	List<Orders> findByOrderStatusContaining(String status);

	List<Orders> findAll();

	Optional<Orders> findById(int orderId);

	boolean existsByOrderStatus(String orderStatus);

	Orders save(Orders orders);

	boolean existsById(int orderId);

	void deleteById(int orderId);

}
