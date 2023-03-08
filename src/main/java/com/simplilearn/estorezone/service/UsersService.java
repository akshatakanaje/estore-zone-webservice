package com.simplilearn.estorezone.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.estorezone.admin.entity.Users;

public interface UsersService {

	List<Users> findByEmailContaining(String email);

	List<Users> findAll();

	Optional<Users> findById(int id);

	boolean existsByEmail(String email);

	Users save(Users usersReq);

	boolean existsById(int userId);

	void deleteById(int id);

}
