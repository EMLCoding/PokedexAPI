package com.emlcoding.springboot.backend.apirest.services;

import com.emlcoding.springboot.backend.apirest.entity.UserApp;

public interface UserService {

	public UserApp findByUsername(String username);
}
