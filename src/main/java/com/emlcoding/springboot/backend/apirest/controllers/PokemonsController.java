package com.emlcoding.springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emlcoding.springboot.backend.apirest.entity.CustomError;
import com.emlcoding.springboot.backend.apirest.entity.Pokemon;
import com.emlcoding.springboot.backend.apirest.services.PokemonsService;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonsController {
	
	
	@Autowired
	PokemonsService pokemonsService;

	@GetMapping("/page")
	public ResponseEntity<?> getAllPagination(@RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="2") int size) {
		List<Pokemon> pokemons = new ArrayList<>();
		Map<String, Object> response = new HashMap<>();
		
		try {
			Pageable pageable = PageRequest.of(page, size);
			
			Page<Pokemon> pagePokemons = pokemonsService.findAll(pageable);
			pokemons = pagePokemons.getContent();
			
			response.put("pokemons", pokemons);
			response.put("currentPage", pagePokemons.getNumber());
			response.put("totalItems", pagePokemons.getTotalElements());
			response.put("totalPages", pagePokemons.getTotalPages());
			
			return new ResponseEntity<>(response, HttpStatus.OK);	
		} catch(Exception e) {
			CustomError error = new CustomError();
			error.setReason("An error has occurred. Try again.");
			error.setCodeError(HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<CustomError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPokemon(@PathVariable() Long id) {
		Pokemon pokemon = null;
		
		try {
			pokemon = pokemonsService.getPokemon(id);
			
		} catch(DataAccessException e) {
			CustomError error = new CustomError();
			error.setReason("An error has occurred. Try again.");
			error.setCodeError(HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<CustomError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (pokemon == null) {
			CustomError error = new CustomError();
			error.setReason("The searched pokemon does not exist.");
			error.setCodeError(HttpStatus.NOT_FOUND);
			return new ResponseEntity<CustomError>(error, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Pokemon>(pokemon, HttpStatus.OK);
	}

}
