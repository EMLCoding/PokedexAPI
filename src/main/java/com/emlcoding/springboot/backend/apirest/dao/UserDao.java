package com.emlcoding.springboot.backend.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.emlcoding.springboot.backend.apirest.entity.UserApp;

public interface UserDao extends CrudRepository<UserApp, Long>{
	
	UserApp findByUsername(String username);

}
