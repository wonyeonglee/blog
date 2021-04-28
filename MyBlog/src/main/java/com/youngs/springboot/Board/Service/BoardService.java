package com.youngs.springboot.Board.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.youngs.springboot.Board.dao.BoardDao;
import com.youngs.springboot.Board.dto.BoardDto;
import com.youngs.springboot.Board.dto.CommentDto;



public interface BoardService {
	
	public List<BoardDto> getBoardList() throws Exception;
	public BoardDto getContentByidx(BoardDto boardDto) throws Exception;
	public void insertContent(BoardDto boardDto) throws Exception;
	public void updateDeleteYn(BoardDto boardDto) throws Exception;
	public void insertComment(CommentDto commentDto) throws Exception;
	public List<CommentDto> getCommentList(CommentDto commentDto) throws Exception;
}
