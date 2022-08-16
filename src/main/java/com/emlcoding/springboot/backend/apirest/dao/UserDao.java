package com.emlcoding.springboot.backend.apirest.dao;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import com.emlcoding.springboot.backend.apirest.entity.Usuario;

public interface UserDao extends CrudRepository<Usuario, Long>{
	
	Usuario findByUsername(String username);

}
