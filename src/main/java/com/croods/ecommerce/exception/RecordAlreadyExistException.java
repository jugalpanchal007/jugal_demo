package com.croods.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class RecordAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecordAlreadyExistException(String message) {
		super(message);
	}
}
