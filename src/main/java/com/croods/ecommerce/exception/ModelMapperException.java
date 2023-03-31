package com.croods.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ModelMapperException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ModelMapperException(String message) {
		super(message);
	}
}
