package com.simplilearn.estorezone.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.simplilearn.estorezone.admin.entity.Orders;
import com.simplilearn.estorezone.exceptions.AlreadyExistException;
import com.simplilearn.estorezone.exceptions.NotFoundException;
import com.simplilearn.estorezone.service.OrdersService;

@RestController()
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	OrdersService ordersService;
	
	/**
	 * Get all Orders or Search Orders by title like operation.
	 * @param title
	 * @return
	 */
	@GetMapping
	public List<Orders> getAll(@RequestParam(value="status", required =false) String status){
		if(status != null && status != "") {
			return ordersService.findByOrderStatusContaining(status);
		}	
		return ordersService.findAll();
	}
	
	/**
	 * Get one order by id
	 * @param orderId
	 * @return
	 */
	@GetMapping("/{orderId}")
	public Optional<Orders> getOne(@PathVariable ("orderId") int orderId){
		Optional<Orders> productData = ordersService.findById(orderId);
		if(productData.isPresent()) {
			return productData;
		}
		throw new NotFoundException("Order does not exist with orderId '"+ orderId +"'");
	}
	
	/**
	 * Save order.
	 * @param order
	 * @return
	 */
	@PostMapping
	public Orders save(@RequestBody Orders orders) {
		boolean exists = ordersService.existsByOrderStatus(orders.getOrderStatus());
		if(!exists) {
			return ordersService.save(orders);
		}
		throw new AlreadyExistException("Order already exist with status '"+ orders.getOrderStatus() +"'");
	}
	
	/**
	 * Update order
	 * @param order
	 * @return
	 */
	@PutMapping
	public Orders update(@RequestBody Orders orders) {
		boolean exists = ordersService.existsById(orders.getOrderId());
		if(exists) {
			return ordersService.save(orders);
		}
		throw new NotFoundException("Order does not exist with orderId '"+ orders.getOrderId() +"'");
	}
	
	/**
	 * Delete one order by id
	 * @param orderId
	 * @return Optional<Products>
	 */
	@DeleteMapping("/{orderId}")
	public ResponseDto deleteOne(@PathVariable("orderId") int orderId) {
		boolean exists = ordersService.existsById(orderId);
		if(exists) {
			ordersService.deleteById(orderId);
			return new ResponseDto("Success","Product deleted", new Date(), null);
		}
		throw new NotFoundException("Order does not exist with orderId '"+ orderId +"'");		
	}
}
