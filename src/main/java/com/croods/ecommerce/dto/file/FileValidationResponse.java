package com.croods.ecommerce.dto.file;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileValidationResponse {

	private boolean isValid;
	
	private String message;

	public FileValidationResponse(boolean isValid, String message) {
		super();
		this.isValid = isValid;
		this.message = message;
	}
}
