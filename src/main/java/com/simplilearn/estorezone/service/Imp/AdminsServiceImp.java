package com.simplilearn.estorezone.service.Imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.simplilearn.estorezone.admin.entity.Admins;
import com.simplilearn.estorezone.repository.AdminsRepository;
import com.simplilearn.estorezone.service.AdminsService;

@Service
public class AdminsServiceImp implements AdminsService{

	@Autowired
	AdminsRepository adminsRepository;
	
	BCryptPasswordEncoder passwordEncoder;
    //Encryption is the process by which a readable message is converted to an unreadable form to prevent unauthorized parties
	                                               //from reading it.
	//Decryption is the process of converting an encrypted message back to its original (readable) format.
	
	@Override
	public Page<Admins> findByEmailContaining(String email, Pageable pageable) {	
		return adminsRepository.findByEmailContaining(email, pageable);
	}

	@Override
	public Page<Admins> findAll(Pageable pageable) {		
		return adminsRepository.findAll(pageable);
	}

	@Override
	public Optional<Admins> findById(int id) {		
		return adminsRepository.findById(id);
	}

	@Override
	public boolean existsByEmail(String email) {		
		return adminsRepository.existsByEmail(email);
	}

	@Override
	public Admins save(Admins adminsReq) {
		passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(adminsReq.getPassword());
		adminsReq.setPassword(encodedPassword);
		return adminsRepository.save(adminsReq);
	}

	@Override
	public boolean existsById(int adminId) {
		return adminsRepository.existsById(adminId);
	}

	@Override
	public void deleteById(int id) {
		adminsRepository.deleteById(id);		
	}

}
