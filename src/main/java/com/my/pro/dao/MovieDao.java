package com.my.pro.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MovieDao implements IMovieDao {
	
	private final String NAMESPACE = "com.my.pro.MovieMapper.";
}
