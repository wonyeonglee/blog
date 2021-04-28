package com.youngs.springboot.Board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentDto {
	
	private int idx;
	private int seq;
	private String content;
	private String date;
	private String delete_yn;
	private String writer;
	private String password;

}
