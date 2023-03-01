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
 * Categories Model
 * @author akshata
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categories")
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="categoryId")
	private int categoryId;
	
	@Column(name="categoryName")
	private String categoryName;
	
	@Column(name="categoryDescription")
	private String categoryDescription;
	
	@Column(name=" categoryImageUrl")
	private String categoryImageUrl;
	
	@Column(name="active")
	private int  active;
	
	@Column(name="addedOn")
	private Date addedOn;
}
