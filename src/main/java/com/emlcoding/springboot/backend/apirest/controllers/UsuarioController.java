package com.emlcoding.springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
