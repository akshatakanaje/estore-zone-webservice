package com.simplilearn.estorezone.controllers;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.estorezone.admin.dto.ResponseDto;
import com.simplilearn.estorezone.enduser.entity.WhishList;
import com.simplilearn.estorezone.exceptions.AlreadyExistException;
import com.simplilearn.estorezone.exceptions.NotFoundException;
import com.simplilearn.estorezone.service.WhishListService;

@RestController
@RequestMapping("/whishlist")
public class WhishListController {
	
	@Autowired
	WhishListService whishListService;
	
	/**
	 * Get all whishlist.
	 * @param  id
	 * @return
	 */
	@GetMapping
	public Page<WhishList> getAll(@RequestParam(value = "userId", required = false) String userId, Pageable pageable){
		if( userId != null) {
			return  whishListService.findByUserId(Integer.parseInt(userId), pageable);
		}
		return whishListService.findAll(pageable);
	}
	
	/**
	 * Get whishList by id
	 * @param id
	 * @return
	 */
	@GetMapping("/{whishListId}")
	public Optional<WhishList> getOne(@PathVariable("whishListId") int whishListId){
		Optional<WhishList> whishListData = whishListService.findById(whishListId);
		if(whishListData.isPresent()) {
			return whishListData;
		}
		throw new NotFoundException("WhishList does not exist with id '"+ whishListId +"'");
	}
	
	/**
	 * Create whishList.
	 * @param whishList
	 * @return
	 */
	@PostMapping
	public WhishList save(@RequestBody WhishList whishList) {
		boolean exists = whishListService.existsById(whishList.getWhishListId());
		if(!exists) {
			return whishListService.save(whishList);
		}
		throw new AlreadyExistException("WhishList is already exist with id'"+ whishList.getWhishListId() +"'");
	}
	
	
	/**
	 * Update whishList.
	 * @param whishList
	 * @return
	 */
	@PutMapping
	public WhishList update(@RequestBody WhishList whishList) {
		boolean exists = whishListService.existsById(whishList.getWhishListId());
		if(exists) {
			return whishListService.save(whishList);
		}
		throw new NotFoundException("WhishList does not exist with whishListId '"+ whishList.getWhishListId() +"'");
	}
	
	/**
	 * Delete one whish by id
	 * @param whishId
	 * @return 
	 */
	@DeleteMapping("/{whishListId}")
	public ResponseDto deleteOne(@PathVariable("whishListId") int whishListId) {
		boolean exists = whishListService.existsById(whishListId);
		if(exists) {
			whishListService.deleteById(whishListId);
			return new ResponseDto("Success","Cart deleted", new Date(), null);
		}
		throw new NotFoundException("WhishList does not exist with whishListId '"+ whishListId +"'");
	}
}
