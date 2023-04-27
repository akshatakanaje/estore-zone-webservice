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

import com.simplilearn.estorezone.admin.dto.LoginReqDto;
import com.simplilearn.estorezone.admin.dto.ResponseDto;
import com.simplilearn.estorezone.admin.entity.Users;
import com.simplilearn.estorezone.exceptions.AlreadyExistException;
import com.simplilearn.estorezone.exceptions.NotFoundException;
import com.simplilearn.estorezone.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UsersService usersService;

	/**
	 * Get all or search by email.
	 * 
	 * @param email
	 * @return
	 */
	@GetMapping
	public Page<Users> getAll(@RequestParam(value = "email", required = false) String email, Pageable pageable) {
		if (email != null) {
			return usersService.findByEmailContaining(email, pageable);
		}
		return usersService.findAll(pageable);
	}

	/**
	 * Get user by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Optional<Users> getOne(@PathVariable("id") int id) {
		Optional<Users> userData = usersService.findById(id);
		if (userData.isPresent()) {
			return userData;
		}
		throw new NotFoundException("Users data does not exist with id '" + id + "'");
	}

	/**
	 * Create user
	 * 
	 * @param usersReq
	 * @return
	 */
	@PostMapping
	public Users save(@RequestBody Users users) {
		boolean exists = usersService.existsByEmail(users.getEmail());
		if (!exists) {
			return usersService.save(users);
		}
		throw new AlreadyExistException("User data already exist with email '" + users.getEmail() + "'");
	}

	/**
	 * Update user
	 * 
	 * @param usersReq
	 * @return
	 */
	@PutMapping
	public Users update(@RequestBody Users users) {
		boolean exists = usersService.existsById(users.getUserId());
		if (exists) {
			return usersService.save(users);
		}
		throw new AlreadyExistException("User data already exist with Id '" + users.getUserId() + "'");
	}

	/**
	 * Delete one user by id
	 * 
	 * @param userId
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseDto deleteOne(@PathVariable("id") int id) {
		boolean exists = usersService.existsById(id);
		if (exists) {
			usersService.deleteById(id);
			return new ResponseDto("Success", "User deleted", new Date(), null);
		}
		throw new NotFoundException("User does not exist with id '" + id + "'");
	}
	
	/**
	 * Validate Login for admin user.
	 * @param adminsReq
	 * @return
	 */
	@PostMapping("/login")
	public ResponseDto save(@RequestBody() LoginReqDto loginReqDto) {
		boolean eixts = usersService.existsByEmail(loginReqDto.getEmail());
		if (eixts) {
			boolean match = usersService.login(loginReqDto);
			Users user = usersService.findByEmail(loginReqDto.getEmail());//we need to find user by email whether user is exist or not
			if(match) {
				return new ResponseDto("Success","User login successfull", new Date(), user); 
			}else {
				throw new NotFoundException("Invalid password, password mismatch error.");
			}
		}
		throw new NotFoundException("User does exist with email '"+loginReqDto.getEmail() +"'");
	}
}
