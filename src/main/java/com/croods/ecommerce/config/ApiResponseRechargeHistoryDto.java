package com.croods.ecommerce.config;

import java.util.List;

import com.croods.ecommerce.dto.RechargeHistoryAppDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponseRechargeHistoryDto {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "status")
	private boolean status;

	@JsonProperty(value = "message")
	private String message;

	@JsonProperty(value = "response")
	private List<RechargeHistoryAppDto> response;
}
