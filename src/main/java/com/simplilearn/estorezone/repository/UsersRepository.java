package com.simplilearn.estorezone.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.estorezone.admin.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

	Page<Users> findByEmailContaining(String email, Pageable pageable);

	boolean existsByEmail(String email);

	Users findByEmail(String email);

}
