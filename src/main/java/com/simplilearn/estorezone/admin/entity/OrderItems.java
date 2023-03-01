package com.simplilearn.estorezone.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_items")
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="orderItemId")
	private int orderItemId;
	
	@Column(name="orderId")
	private int orderId;
	
	@Column(name="productId")
	private int productId;
	
	@Column(name="productCode")
	private String productCode;
	
	@Column(name=" productImg")
	private String productImg;
	
	@Column(name="productTitle")
	private String productTitle;
	
	@Column(name="productDescription")
	private String productDescription;
	
	@Column(name="productCategory")
	private String productCategory;
	
	@Column(name="price")
	private int price;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="totalPrice")
	private int totalPrice;
	
}