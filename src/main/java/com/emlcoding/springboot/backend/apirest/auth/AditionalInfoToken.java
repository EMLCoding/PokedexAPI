package com.emlcoding.springboot.backend.apirest.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.emlcoding.springboot.backend.apirest.entity.UserApp;
import com.emlcoding.springboot.backend.apirest.services.UserService;

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
