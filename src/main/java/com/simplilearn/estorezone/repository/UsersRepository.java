package com.simplilearn.estorezone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.estorezone.admin.entity.Users;



@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

	List<Users> findByEmailContaining(String email);

	boolean existsByEmail(String email);

}
