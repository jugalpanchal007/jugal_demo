package com.croods.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CommonApiException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CommonApiException(String message) {
		super(message);
	}
}
