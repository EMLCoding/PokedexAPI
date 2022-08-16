package com.emlcoding.springboot.backend.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.emlcoding.springboot.backend.apirest.entity.Types;

public interface TypesDao extends JpaRepository<Types, Long>{

}
