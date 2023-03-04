package com.simplilearn.estorezone.enduser.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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