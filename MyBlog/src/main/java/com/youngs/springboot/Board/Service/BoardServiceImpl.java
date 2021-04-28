package com.youngs.springboot.Board.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youngs.springboot.Board.dao.BoardDao;
import com.youngs.springboot.Board.dao.BoardDaoImpl;
import com.youngs.springboot.Board.dto.BoardDto;
import com.youngs.springboot.Board.dto.CommentDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	
	@Autowired
	BoardDaoImpl boarddao;
	
	@Override
	public List<BoardDto> getBoardList() throws Exception {

		List<BoardDto> results = boarddao.selectBoardList();

		return results;
	}
	@Override
	public BoardDto getContentByidx(BoardDto boardDto) throws Exception{
		boarddao.updateHitByidx(boardDto);
		return boarddao.getContentByidx(boardDto);
	}
	
	@Override
	public void insertContent(BoardDto boardDto) throws Exception{
		boarddao.insertContent(boardDto);
	}
	@Override
	public void updateDeleteYn(BoardDto boardDto) throws Exception{
		boarddao.updateDeleteYn(boardDto);
	}
	@Override
	public void insertComment(CommentDto commentDto) throws Exception{
		boarddao.insertComment(commentDto);
	}
	@Override
	public List<CommentDto> getCommentList(CommentDto commentDto) throws Exception{
		return boarddao.selectCommentList(commentDto);
	}
}
