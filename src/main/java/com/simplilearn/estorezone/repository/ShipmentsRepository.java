package com.simplilearn.estorezone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.simplilearn.estorezone.admin.entity.Shipments;

@Repository
public interface ShipmentsRepository extends JpaRepository<Shipments, Integer>{

	List<Shipments> findByShipmentStatusContaining(String status);

	boolean existsByShipmentStatus(int shipmentStatus);

}
