package com.simplilearn.estorezone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.simplilearn.estorezone.admin.entity.Shipments;

public interface ShipmentsService {

	Page<Shipments> findByShipmentStatusContaining(String status, Pageable pageable);

	Page<Shipments> findAll(Pageable pageable);

	Optional<Shipments> findById(int shipmentId);

	boolean existsByShipmentStatus(int shipmentStatus);

	Shipments save(Shipments shipments);

	boolean existsById(int shipmentId);

	void deleteById(int shipmentId);

}
