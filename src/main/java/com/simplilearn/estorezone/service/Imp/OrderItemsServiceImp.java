package com.simplilearn.estorezone.service.Imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.simplilearn.estorezone.admin.entity.OrderItems;
import com.simplilearn.estorezone.repository.OrderItemsRepository;
import com.simplilearn.estorezone.service.OrderItemsService;

@Service
public class OrderItemsServiceImp implements OrderItemsService{
	
	@Autowired 
	OrderItemsRepository orderItemsRepository;

	@Override
	public Page<OrderItems> findByProductTitleContaining(String title, Pageable pageable) {
		return orderItemsRepository.findByProductTitleContaining(title, pageable);
	}

	@Override
	public Page<OrderItems> findAll(Pageable pageable) {
		return orderItemsRepository.findAll(pageable);
	}

	@Override
	public Optional<OrderItems> findById(int orderItemId) {
		return orderItemsRepository.findById(orderItemId);
	}

	@Override
	public boolean existsById(int orderItemId) {
		return orderItemsRepository.existsById(orderItemId);
	}

	@Override
	public OrderItems save(OrderItems orderItems) {
		return orderItemsRepository.save(orderItems);
	}

	@Override
	public void deleteById(int orderItemId) {
		orderItemsRepository.deleteById(orderItemId);
		
	} 
}
