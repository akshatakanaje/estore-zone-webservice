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


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "shipments")
public class Shipments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="shipmentId")
	private int shipmentId;
	
	@Column(name="orderId")
	private int  orderId;
	
	@Column(name="shipmentStatus")
	private int shipmentStatus;
	
	@Column(name="shipmentTitle")
	private String  shipmentTitle;
	
	@Column(name="shipmentDate")
	private Date shipmentDate;
	
	@Column(name="expectedDeliveryDate")
	private Date  expectedDeliveryDate;
	
	@Column(name="shipmentMethod")
	private String  shipmentMethod ;
	
	@Column(name="shipmentCompany")
	private String shipmentCompany;

}
