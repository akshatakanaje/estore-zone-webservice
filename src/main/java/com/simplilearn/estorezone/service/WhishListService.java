package com.simplilearn.estorezone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.simplilearn.estorezone.enduser.entity.WhishList;

public interface WhishListService {

	Page<WhishList> findByUserId(int userId, Pageable pageable);

	Page<WhishList> findAll(Pageable pageable);

	Optional<WhishList> findById(int whishListId);

	boolean existsById(int whishListId);

	WhishList save(WhishList whishList);

	void deleteById(int whishListId);

}
