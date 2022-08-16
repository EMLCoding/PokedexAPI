package com.emlcoding.springboot.backend.apirest.services;

import com.emlcoding.springboot.backend.apirest.entity.Usuario;
import java.util.List;

public interface UserService {

	public Usuario findByUsername(String username);
	
	public List<Usuario> findAll();
	
	public Usuario registerUser(Usuario usuario);
}
