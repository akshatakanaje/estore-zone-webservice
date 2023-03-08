package com.simplilearn.estorezone.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.estorezone.admin.entity.Shipments;

public interface ShipmentsService {

	List<Shipments> findByShipmentStatusContaining(String status);

	List<Shipments> findAll();

	Optional<Shipments> findById(int shipmentId);

	boolean existsByShipmentStatus(int shipmentStatus);

	Shipments save(Shipments shipments);

	boolean existsById(int shipmentId);

	void deleteById(int shipmentId);

}
