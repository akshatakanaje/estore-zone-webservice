package com.simplilearn.estorezone.enduser.model;

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
public class Whishlist {
	
	//wishList model properties
	private int whishListId;
	private int productId;
	private int userId;
	
}