package com.my.pro;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.my.pro.dto.MovieRequestDto;
import com.my.pro.service.MovieService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = 
	{"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class TestMovieApi {
	
	@Autowired
	private MovieService service;
	
	@Autowired
	private MovieRequestDto movieRequestDto;
	
	@Test
	public void testGetMovieContent() throws JsonParseException, JsonMappingException, IOException {
		/*
		String response = service.getMovieContent("20231120");
		System.out.println("response:" + response);
		ObjectMapper mapper = new ObjectMapper();
		MovieResponseDto movieResponseDto = mapper.readValue(response, MovieResponseDto.class);
		System.out.println("movieReponseDto:" + movieResponseDto);
		*/

		String response = getMovieContent();
		System.out.println("response:" + response);
	}
	
	public String getMovieContent() throws UnsupportedEncodingException {
//		String encodedTitle = URLEncoder.encode("인셉션", StandardCharsets.UTF_8.toString());
		UriComponents uriComponents = UriComponentsBuilder
				.fromHttpUrl("http://www.omdbapi.com/")
				.queryParam("apikey", movieRequestDto.getMovie_key())
				.queryParam("t", "inception")
				.build();
		try {
			URL url = new URL(uriComponents.toString());
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			return readResponse(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String readResponse(HttpURLConnection connection) throws IOException {
		int responseCode = connection.getResponseCode();
		BufferedReader br;
		
		br = (responseCode == 200) 
			? new BufferedReader(new InputStreamReader(connection.getInputStream()))
			: new BufferedReader(new InputStreamReader(connection.getErrorStream()));
		String inputLine;
		StringBuffer bf = new StringBuffer();
		while((inputLine = br.readLine()) != null) {
			bf.append(inputLine);
		}
		br.close();
		return bf.toString();
	}
}
