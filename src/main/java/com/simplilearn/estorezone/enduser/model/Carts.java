package com.simplilearn.estorezone.enduser.model;

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
public class Carts {
	
	//carts model attributes
	private int cartId;
	private int productId;
	private int userId;
	private int quantity;
}
