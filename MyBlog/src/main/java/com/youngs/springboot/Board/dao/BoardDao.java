package com.youngs.springboot.Board.dao;

import java.util.List;

import com.youngs.springboot.Board.dto.BoardDto;
import com.youngs.springboot.Board.dto.CommentDto;



public interface BoardDao {
	public List<BoardDto> selectBoardList() throws Exception;
	
	public BoardDto getContentByidx(BoardDto boardDto) throws Exception;
	public void updateHitByidx(BoardDto boardDto) throws Exception;
	public void insertContent(BoardDto boardDto) throws Exception;
	public void updateDeleteYn(BoardDto boardDto) throws Exception;
	public void insertComment(CommentDto commentDto) throws Exception;
	public List<CommentDto> selectCommentList(CommentDto commentDto) throws Exception;

}
