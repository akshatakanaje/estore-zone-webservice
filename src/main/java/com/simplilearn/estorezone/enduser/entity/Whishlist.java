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
 * WishList Mode
 * @author Akshata 
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Whishlist")
public class Whishlist {
	
	//wishList model properties
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="whishListId")
	private int whishListId;
	
	@Column(name="productId")
	private int productId;
	
	@Column(name="userId")
	private int userId;
	
}