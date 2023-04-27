package com.simplilearn.estorezone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.simplilearn.estorezone.admin.dto.LoginReqDto;
import com.simplilearn.estorezone.admin.entity.Users;

public interface UsersService {

	Page<Users> findByEmailContaining(String email, Pageable pageable);

	Page<Users> findAll(Pageable pageable);

	Optional<Users> findById(int id);

	boolean existsByEmail(String email);

	Users save(Users users);

	boolean existsById(int userId);

	void deleteById(int id);

	boolean login(LoginReqDto loginReqDto);

	Users findByEmail(String email);

}
