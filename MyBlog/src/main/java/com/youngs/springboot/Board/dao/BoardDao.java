package com.youngs.springboot.Board.dao;

import java.util.List;

import com.youngs.springboot.Board.dto.BoardDto;



public interface BoardDao {
	public List<BoardDto> selectBoardList() throws Exception;
	
	public BoardDto getContentByidx(BoardDto boardDto) throws Exception;

}
