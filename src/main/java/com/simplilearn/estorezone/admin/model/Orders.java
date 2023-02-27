package com.simplilearn.estorezone.admin.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Orders Model
 * @author akshatakanaje
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
	
	//order details properties
	private int orderId;
	private Date orderDate;
	private String orderStatus;
	
	//pricing properties
	private int totalItems;
	private int itemsSubTotal;
	private int shipmentCharges;
	private int totalAmount;
	
	//payment status properties
	private String paymentStatusTitle;
	private int paymentMethod;
	private String paymentMethodTitle;
	private int paymentStatus;
	
	//customer/user properties
	private int userId;
	private String email;
	private String address;
	private String name;
	private Long contact;
}
