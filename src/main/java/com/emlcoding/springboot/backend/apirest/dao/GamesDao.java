package com.emlcoding.springboot.backend.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emlcoding.springboot.backend.apirest.entity.Game;

public interface GamesDao extends JpaRepository<Game, Long>{

}
