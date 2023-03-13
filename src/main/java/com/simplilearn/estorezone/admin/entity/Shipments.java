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
	private Date shipmentDate = new Date();
	
	@Column(name="expectedDeliveryDate")
	private Date  expectedDeliveryDate;
	
	@Column(name="shipmentMethod")
	private String  shipmentMethod ;
	
	@Column(name="shipmentCompany")
	private String shipmentCompany;

}
