package com.simplilearn.estorezone.admin.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "orders")
public class Orders {
	
	//order details properties
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="orderId")
	private int orderId;
	
	@Column(name="orderDate")
	private Date orderDate;
	
	@Column(name="orderStatus")
	private String orderStatus;
	
	//pricing properties
	@Column(name="totalItems")
	private int totalItems;
	
	@Column(name="itemsSubTotal")
	private int itemsSubTotal;
	
	@Column(name="shipmentCharges")
	private int shipmentCharges;
	
	@Column(name="totalAmount")
	private int totalAmount;
	
	//payment status properties
	@Column(name="paymentStatusTitle")
	private String paymentStatusTitle;
	
	@Column(name="paymentMethod")
	private int paymentMethod;
	
	@Column(name="paymentMethodTitle")
	private String paymentMethodTitle;
	
	@Column(name="paymentStatus")
	private int paymentStatus;
	
	//customer/user properties
	@Column(name="userId")
	private int userId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;
	
	@Column(name="name")
	private String name;
	
	@Column(name="contact")
	private Long contact;
}
