package com.curso.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.repository.IUserRepository;

@Service
public class IUsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUserRepository userRepository;

	@Override
	public Optional<Usuario> findById(Integer id) {
		
		return userRepository.findById(id);
	}

}
