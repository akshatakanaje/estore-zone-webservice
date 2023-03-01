package com.simplilearn.estorezone.enduser.entity;

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
 * carts Model
 * @author akshata
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "carts")
public class Carts {
	
	//carts model attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cartId")
	private int cartId;
	
	@Column(name="productId")
	private int productId;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="quantity")
	private int quantity;
}
