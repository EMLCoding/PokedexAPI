package com.emlcoding.springboot.backend.apirest.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emlcoding.springboot.backend.apirest.entity.Usuario;
import com.emlcoding.springboot.backend.apirest.services.UserService;

/*
@Component
public class AditionalInfoToken implements TokenEnhancer{
	
	@Autowired
	private UserService userService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		UserApp user = userService.findByUsername(authentication.getName());
		
		Map<String, Object> info = new HashMap<>();
		
		info.put("user_name", user.getUsername() + " - " + user.getId());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
*/
