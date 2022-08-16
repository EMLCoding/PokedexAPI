package com.emlcoding.springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

import com.emlcoding.springboot.backend.apirest.entity.CustomError;
import com.emlcoding.springboot.backend.apirest.entity.Usuario;
import com.emlcoding.springboot.backend.apirest.services.UserService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	UserService userService;
	
	@GetMapping()
	public ResponseEntity<?> getAllUsers() {
		List<Usuario> usuarios = new ArrayList<>();
		
		try {
			usuarios = userService.findAll();
			
			
		} catch (Exception e) {
			CustomError error = new CustomError();
			error.setReason("An error has occurred. Try again.");
			error.setCodeError(HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<CustomError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> registerNewUser(@RequestBody Usuario user) {
		Usuario newUser = null;
		
		try {
			newUser = userService.registerUser(user);
		} catch(DataAccessException e) {
			CustomError error = new CustomError();
			error.setReason("Error register new user.");
			return new ResponseEntity<CustomError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Usuario>(newUser, HttpStatus.OK);
	}

}
