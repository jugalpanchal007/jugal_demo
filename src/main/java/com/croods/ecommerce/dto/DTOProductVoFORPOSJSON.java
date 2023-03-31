package com.croods.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DTOProductVoFORPOSJSON {

	@JsonProperty(value = "id")
	private long id;

	@JsonProperty(value = "value")
	private String value;

}