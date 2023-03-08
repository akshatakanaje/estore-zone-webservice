package com.simplilearn.estorezone.service.Imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.simplilearn.estorezone.admin.entity.Shipments;
import com.simplilearn.estorezone.repository.ShipmentsRepository;
import com.simplilearn.estorezone.service.ShipmentsService;

@Service
public class ShipmentsServiceImp implements ShipmentsService{

	@Autowired
	ShipmentsRepository shipmentsRepository;
	
	@Override
	public Page<Shipments> findByShipmentStatusContaining(String status, Pageable pageable) {
		return shipmentsRepository.findByShipmentStatusContaining(status, pageable);
	}

	@Override
	public Page<Shipments> findAll(Pageable pageable) {
		return shipmentsRepository.findAll(pageable);
	}

	@Override
	public Optional<Shipments> findById(int shipmentId) {
		return shipmentsRepository.findById(shipmentId);
	}

	@Override
	public boolean existsByShipmentStatus(int shipmentStatus) {
		return shipmentsRepository.existsByShipmentStatus(shipmentStatus);
	}

	@Override
	public Shipments save(Shipments shipments) {
		return shipmentsRepository.save(shipments);
	}

	@Override
	public boolean existsById(int shipmentId) {
		return shipmentsRepository.existsById(shipmentId);
	}

	@Override
	public void deleteById(int shipmentId) {
		shipmentsRepository.deleteById(shipmentId);		
	}

}
