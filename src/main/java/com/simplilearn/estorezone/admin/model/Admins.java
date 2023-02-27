package com.simplilearn.estorezone.admin.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Admin Model
 * @author Akshata
 *
 */
@AllArgsConstructor  //parameterized constructor 
@NoArgsConstructor   //default constructor
@Data                //setters and getters
public class Admins {
		
	private int adminId;
	private String email;
	private String password;
	private String fullName;
	private int loginType;
	private Date addedOn;
	
	

	


}
