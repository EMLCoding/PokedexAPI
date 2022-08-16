package com.emlcoding.springboot.backend.apirest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emlcoding.springboot.backend.apirest.dao.PokemonsDao;
import com.emlcoding.springboot.backend.apirest.entity.Pokemon;
import com.emlcoding.springboot.backend.apirest.services.PokemonsService;

@Service
public class PokemonsServiceImpl implements PokemonsService{
	
	
	@Autowired
	private PokemonsDao pokemonsDao;

	@Override
	@Transactional(readOnly = true)
	public Page<Pokemon> findAll(Pageable pageable) {
		return pokemonsDao.findAllPaginable(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Pokemon getPokemon(Long id) {
		return pokemonsDao.findById(id).orElse(null);
	}

}
