package com.simplilearn.estorezone.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.simplilearn.estorezone.admin.entity.Shipments;

@Repository
public interface ShipmentsRepository extends JpaRepository<Shipments, Integer>{

	Page<Shipments> findByShipmentStatusContaining(String status, Pageable pageable);

	boolean existsByShipmentStatus(int shipmentStatus);

}
