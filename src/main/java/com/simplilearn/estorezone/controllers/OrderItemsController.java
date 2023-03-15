package com.simplilearn.estorezone.controllers;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.estorezone.admin.dto.ResponseDto;
import com.simplilearn.estorezone.admin.entity.OrderItems;
import com.simplilearn.estorezone.exceptions.AlreadyExistException;
import com.simplilearn.estorezone.exceptions.NotFoundException;
import com.simplilearn.estorezone.service.OrderItemsService;

@RestController
@RequestMapping("/orderitems")
public class OrderItemsController {
	
	 @Autowired
	 OrderItemsService orderItemsService;
	 
	 /**
		 * Get all orderItems or Search orderItem by title like operation.
		 * @param title
		 * @return
		 */
	 @GetMapping
	 public Page<OrderItems> getAll(@RequestParam(value="title", required=false) String title, Pageable pageable){
		 if(title != null && title != "") {
			 return orderItemsService.findByProductTitleContaining(title, pageable);
		 }
		 return orderItemsService.findAll(pageable);
	 }
	 
	 /**
		 * Get one orderItem by id
		 * @param id
		 * @return
		 */
	@GetMapping("/{orderItemId}")
	 public Optional<OrderItems> getOne(@PathVariable("orderItemId") int orderItemId){
		 Optional<OrderItems> orderItemData = orderItemsService.findById(orderItemId);
		 if(orderItemData.isPresent()) {
			 return orderItemData;
		 }
		 throw new NotFoundException("OrderItem does not exist with orderItemId '"+ orderItemId +"'");
	 }
	

		/**
		 * Save orderItems.
		 * @param orderItems
		 * @return
		 */
	@PostMapping	
	public OrderItems save(@RequestBody OrderItems orderItems){
		boolean exists = orderItemsService.existsById(orderItems.getOrderItemId());
		if(!exists) {
			return orderItemsService.save(orderItems);
		}
		throw new AlreadyExistException("OrderItem already exist with name '"+ orderItems.getOrderItemId()+"'");
	}
	
	/**
	 * Update orderItems
	 * @param orderItems
	 * @return
	 */
	@PutMapping
	public OrderItems update(@RequestBody OrderItems orderItems) {
		boolean exists = orderItemsService.existsById(orderItems.getOrderItemId());
		if(exists) {
			return orderItemsService.save(orderItems);
		}
		throw new NotFoundException("OrderItem does not exist with id '"+ orderItems.getOrderItemId() +"'");
	}
	
	/**
	 * Delete one orderItem by id
	 * @param  orderItemId
	 * @return 
	 */
	@DeleteMapping("/{orderItemId}")
	public ResponseDto delete(@PathVariable("orderItemId") int orderItemId) {
		boolean exists = orderItemsService.existsById(orderItemId);
		if(exists) {
			orderItemsService.deleteById(orderItemId);
			return new ResponseDto("Success","OrderItem deleted", new Date(), null);
		}
		throw new NotFoundException("Carts does not exist with Id '"+ orderItemId +"'");
	}
}
