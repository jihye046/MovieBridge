package com.my.pro.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.pro.dto.MovieResponseDto;
import com.my.pro.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@RequestMapping("/getMovieContent")
	public void getMovieContent(String targetDt) throws JsonParseException, JsonMappingException, IOException {
		String response = service.getMovieContent(targetDt);
		System.out.println("response:" + response);
		ObjectMapper mapper = new ObjectMapper();
		MovieResponseDto movieResponseDto = mapper.readValue(response, MovieResponseDto.class);
		System.out.println("movieReponseDto:" + movieResponseDto);
	}
}
