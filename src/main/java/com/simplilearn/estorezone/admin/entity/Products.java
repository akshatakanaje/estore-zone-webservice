package com.simplilearn.estorezone.admin.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Products Model
 * @author akshata
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Products {
	
	//products model attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="productId")
	private int productId;
	
	@Column(name="productTitle")
	private String productTitle;
	
	@Column(name="productDescription")
	private String productDescription;
	
	@Column(name="productCode")
	private String productCode;
	
	@ElementCollection
	@CollectionTable(name="images", joinColumns = @JoinColumn(name="id"))
	@Column(name="list")
	private List<String> images;
	
	@Column(name="thumbnailImage")
	private int thumbnailImage;
	
	@Column(name="price")
	private double price;
	
	@Column(name="addedOn")
	private Date addedOn = new Date();
	
	@Column(name="rating")
	private double rating;
}
