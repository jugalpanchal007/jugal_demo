package com.croods.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class ApiKeyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ApiKeyException(String message) {
		super(message);
	}
}
