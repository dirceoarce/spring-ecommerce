package com.curso.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.ecommerce.model.Orden;
import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.repository.IOrdenRepository;

@Service
public class OrdenServiceImpl implements IOrdenService {

	@Autowired
	private IOrdenRepository ordenRepository;
	
	
	public Orden save(Orden orden) {		
		return ordenRepository.save(orden);
	}


	
	public List<Orden> findAll() {
		return ordenRepository.findAll();
	}
	
	//Creando Numero de orden secuencial
	public String generarNumeroOrden() {
		int num=0;
		String numeroConcatenado="";
		
		List<Orden> ordenes = findAll();//Lista de ordenes
		
		List<Integer> numeros = new ArrayList<Integer>();
		
		ordenes.stream().forEach(o -> numeros.add(Integer.parseInt(o.getNumero())));
		
		if(ordenes.isEmpty()) {
			num=1;
		}else {
			num= numeros.stream().max(Integer::compare).get();
			num++;
		}
		
		if (num<10) {
			numeroConcatenado ="000000000" + String.valueOf(num);
		}else if(num<100) {
			numeroConcatenado ="00000000" + String.valueOf(num);			
		}else if(num<1000) {
			numeroConcatenado ="0000000" + String.valueOf(num);
		}else if(num<10000) {
			numeroConcatenado ="000000" + String.valueOf(num);
		}else if(num<100000) {
			numeroConcatenado ="00000" + String.valueOf(num);
		}
		
		return numeroConcatenado;
	}



	@Override
	public List<Orden> findByUsuario(Usuario usuario) {
		
		return ordenRepository.findByUsuario(usuario);
	}



	@Override
	public Optional<Orden> findById(Integer id) {
		
		return ordenRepository.findById(id);
	}

}
