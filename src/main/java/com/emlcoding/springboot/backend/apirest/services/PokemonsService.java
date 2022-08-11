package com.emlcoding.springboot.backend.apirest.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.emlcoding.springboot.backend.apirest.entity.Pokemon;

public interface PokemonsService {
	
	public Page<Pokemon> findAll(Pageable pageable);
	
	public Pokemon getPokemon(Long id);

}
