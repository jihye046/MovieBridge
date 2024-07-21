package com.my.pro.service;

import java.io.IOException;
import java.net.HttpURLConnection;

public interface IMovieService {
	String getMovieContent(String targetDt);
	String readResponse(HttpURLConnection connection) throws IOException;
}
