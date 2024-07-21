package com.my.pro.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyBoxOfficeList {
	
	private String rank; // 해당일자의 박스오피스 순위
	private String ranklnten; // 전일대비 순위의 증감분
	private String rankOldAndNew; // 랭킹에 신규진입여부 출력, 'OLD': 기존, 'NEW': 신규
	private String movieCd; // 영화의 대표코드
	private String movieNm; //영화명(국문)
	private String openDt; // 영화 개봉일
	private String audiCnt; // 해당일 관객수
	private String audilnten; // 전일 대비 관객수 증감분
	private String audiAcc; // 누적관객수
	
}
