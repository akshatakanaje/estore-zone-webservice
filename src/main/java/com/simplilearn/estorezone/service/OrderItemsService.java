package com.simplilearn.estorezone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.simplilearn.estorezone.admin.entity.OrderItems;

public interface OrderItemsService {

	Page<OrderItems> findByProductTitleContaining(String title, Pageable pageable);

	Page<OrderItems> findAll(Pageable pageable);

	Optional<OrderItems> findById(int orderItemId);

	boolean existsById(int orderItemId);

	OrderItems save(OrderItems orderItems);

	void deleteById(int orderItemId);
}
