package com.emlcoding.springboot.backend.apirest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emlcoding.springboot.backend.apirest.entity.Pokemon;


public interface PokemonsDao extends JpaRepository<Pokemon, Long> {

	@Query("SELECT p FROM Pokemon p ORDER BY p.pokedexNum")
	Page<Pokemon> findAllPaginable(Pageable pageable);
}

