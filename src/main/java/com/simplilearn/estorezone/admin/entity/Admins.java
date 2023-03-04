package com.simplilearn.estorezone.admin.entity;

import java.util.Date;

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
 * Admin Model
 * @author Akshata
 *
 */
@AllArgsConstructor  //parameterized constructor 
@NoArgsConstructor   //default constructor
@Data                //combination of setters and getters and toString as well as hashCode
@Entity
@Table(name = "admins")
public class Admins {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="adminId")
	private int adminId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="fullName")
	private String fullName;
	
	@Column(name="loginType")
	private int loginType;
	
	@Column(name="addedOn")
	private Date addedOn;
	
}
