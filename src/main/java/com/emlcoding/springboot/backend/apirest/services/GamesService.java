package com.emlcoding.springboot.backend.apirest.services;

import java.util.List;

import com.emlcoding.springboot.backend.apirest.entity.Game;

public interface GamesService {
	
	public List<Game> findAll();

}
