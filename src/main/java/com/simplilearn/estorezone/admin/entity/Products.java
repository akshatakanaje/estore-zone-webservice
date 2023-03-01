package com.simplilearn.estorezone.admin.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
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
	private int price;
	
	@Column(name="addedOn")
	private Date addedOn;
	
	@Column(name="rating")
	private int rating;
}
