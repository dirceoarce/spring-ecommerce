package com.curso.ecommerce.service;

import org.springframework.stereotype.Service;

import com.curso.ecommerce.model.DetalleOrden;
import com.curso.ecommerce.repository.IDetalleOrdenRepository;

@Service
public class DetalleOrdenServiceImpl implements IDetalleOrdenService{

	private IDetalleOrdenRepository detalleOrdenRepository;
	
	public DetalleOrden save(DetalleOrden detalleOrden) {
		
		return detalleOrdenRepository.save(detalleOrden);
	}

}
