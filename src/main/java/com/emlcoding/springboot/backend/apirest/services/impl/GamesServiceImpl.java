package com.emlcoding.springboot.backend.apirest.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emlcoding.springboot.backend.apirest.dao.GamesDao;
import com.emlcoding.springboot.backend.apirest.entity.Game;
import com.emlcoding.springboot.backend.apirest.services.GamesService;

@Service
public class GamesServiceImpl implements GamesService{
	
	@Autowired
	GamesDao gamesDao;

	@Override
	@Transactional(readOnly = true)
	public List<Game> findAll() {
		return (List<Game>)gamesDao.findAll();
	}

}
