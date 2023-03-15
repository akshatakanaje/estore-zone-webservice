package com.simplilearn.estorezone.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.estorezone.enduser.entity.WhishList;


public interface WhishListRepository extends JpaRepository<WhishList, Integer>{

	Page<WhishList> findByUserId(int userId, Pageable pageable);
}
