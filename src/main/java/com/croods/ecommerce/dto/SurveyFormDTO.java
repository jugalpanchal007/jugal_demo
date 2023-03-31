package com.croods.ecommerce.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class SurveyFormDTO {

	private long userId;
	private List<SurveyAnswerDTO> surveyAnswers;
}