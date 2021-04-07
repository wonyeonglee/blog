package com.youngs.springboot.Board.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.youngs.springboot.Board.dao.BoardDao;
import com.youngs.springboot.Board.dto.BoardDto;



public interface BoardService {
	
	public List<BoardDto> getBoardList() throws Exception;

}
