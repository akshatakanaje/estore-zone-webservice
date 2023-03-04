package com.simplilearn.estorezone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.estorezone.admin.entity.OrderItems;


@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer>{

	List<OrderItems> findByProductTitleContaining(String title);

}
