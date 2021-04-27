package com.youngs.springboot.Board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDto {
	
	
	private int idx;
	private String writer;
	private String title;
	private String content;
	private String date;
	private String hit;
	private String password;

}
