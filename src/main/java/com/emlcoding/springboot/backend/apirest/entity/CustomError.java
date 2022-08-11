package com.emlcoding.springboot.backend.apirest.entity;

import org.springframework.http.HttpStatus;

public class CustomError {

	private String reason;
	
	private HttpStatus codeError;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public HttpStatus getCodeError() {
		return codeError;
	}

	public void setCodeError(HttpStatus codeError) {
		this.codeError = codeError;
	}
	
	
}
