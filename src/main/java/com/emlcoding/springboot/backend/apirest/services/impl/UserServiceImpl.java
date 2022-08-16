package com.emlcoding.springboot.backend.apirest.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emlcoding.springboot.backend.apirest.dao.UserDao;
import com.emlcoding.springboot.backend.apirest.entity.Usuario;
import com.emlcoding.springboot.backend.apirest.services.UserService;


@Service
public class UserServiceImpl implements UserService/*, UserDetailsService*/{

	@Autowired
	UserDao userDao;

	@Override
	public Usuario findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>)userDao.findAll();
	}

	/*
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserApp user = userDao.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Error en el login: no existe el usuario '" + username + "' en el sistema");
		}
		
		List<GrantedAuthority> authorities = user.getRoles()
				.stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getName()))
				.collect(Collectors.toList());
		
		return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly = true)
	public UserApp findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	*/
	

}

