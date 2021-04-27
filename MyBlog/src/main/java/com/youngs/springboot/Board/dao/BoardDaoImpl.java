package com.youngs.springboot.Board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.youngs.springboot.Board.dto.BoardDto;

@Repository
@Mapper
public class BoardDaoImpl implements BoardDao{
	
	@Qualifier("sqlSessionTemplate")
	@Autowired
	public SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception{

		
		List<BoardDto> results = sqlSession.selectList("Board.selectBoardList");
		return results;
		
		
	}
	@Override
	public BoardDto getContentByidx(BoardDto boardDto) throws Exception{
		//조회수 업데이트
		return sqlSession.selectOne("Board.getContentByidx", boardDto);
	}
	
	@Override
	public void updateHitByidx(BoardDto boardDto) throws Exception{
		//조회수 업데이트
		sqlSession.update("Board.updateHitByidx",boardDto);
	}
	
	@Override
	public void insertContent(BoardDto boardDto) throws Exception{
		sqlSession.insert("Board.insertContent", boardDto);
	}

}
