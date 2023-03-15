package com.simplilearn.estorezone.service.Imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.simplilearn.estorezone.admin.entity.Products;
import com.simplilearn.estorezone.enduser.entity.WhishList;
import com.simplilearn.estorezone.repository.ProductsRepository;
import com.simplilearn.estorezone.repository.WhishListRepository;
import com.simplilearn.estorezone.service.WhishListService;

@Service
public class WhishListServiceImp implements WhishListService{

	@Autowired
	WhishListRepository whishListRepository;
	
	@Autowired
	ProductsRepository productsRepository;
	
	@Override
	public Page<WhishList> findByUserId(int userId, Pageable pageable) {
		Page<WhishList> whishList = whishListRepository.findByUserId(userId, pageable);
		for(WhishList whishLists : whishList.getContent()) {
			Products product = productsRepository.findById(whishLists.getProductId()).get();
			whishLists.setProducts(product);
		}
		return whishList;
	}

	@Override
	public Page<WhishList> findAll(Pageable pageable) {		
		return  whishListRepository.findAll(pageable);
	}

	@Override
	public Optional<WhishList> findById(int whishListId) {
		return  whishListRepository.findById(whishListId);
	}

	@Override
	public boolean existsById(int whishListId) {
		return  whishListRepository.existsById(whishListId);
	}

	@Override
	public WhishList save(WhishList whishList) {
		return  whishListRepository.save(whishList);
	}

	@Override
	public void deleteById(int whishListId) {
		 whishListRepository.deleteById(whishListId);
		
	}

}
