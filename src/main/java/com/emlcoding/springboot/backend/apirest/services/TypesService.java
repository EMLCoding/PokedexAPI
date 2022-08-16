package com.emlcoding.springboot.backend.apirest.services;

import java.util.List;

import com.emlcoding.springboot.backend.apirest.entity.Types;

public interface TypesService {

	public List<Types> findAll();
	
	public List<Types> findTypesByPokemon(Long id);
}
