package com.croods.ecommerce.config;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "status")
	private boolean status;

	@JsonProperty(value = "message")
	private String message;

	@JsonProperty(value = "response")
	private Object response;


}
