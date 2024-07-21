package com.my.pro.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.my.pro.dto.response.BoxOfficeResult;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieResponseDto {
	
	private BoxOfficeResult boxOfficeResult;
	
}
