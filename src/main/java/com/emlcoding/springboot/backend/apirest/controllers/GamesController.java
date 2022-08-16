package com.emlcoding.springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emlcoding.springboot.backend.apirest.entity.CustomError;
import com.emlcoding.springboot.backend.apirest.services.GamesService;

@RestController
@RequestMapping("/api/games")
public class GamesController {

	@Autowired
	GamesService gamesService;
	
	@GetMapping()
	public ResponseEntity<?> getAllGames() {
		try {
			return new ResponseEntity<>(gamesService.findAll(), HttpStatus.OK);
		} catch(Exception e) {
			CustomError error = new CustomError();
			error.setReason("An error has occurred getting the games. Try again.");
			error.setCodeError(HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<CustomError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
