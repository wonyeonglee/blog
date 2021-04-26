package com.youngs.springboot.Board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.youngs.springboot.Board.Service.BoardService;
import com.youngs.springboot.Board.Service.BoardServiceImpl;
import com.youngs.springboot.Board.dto.BoardDto;




@Controller
public class BoardController {
	
	@Autowired
	BoardServiceImpl boardservice;
	
	@GetMapping("/board")
	private String board(Model model) throws Exception{
		return "board";
	}
	
	@GetMapping("/getBoardList")
	@ResponseBody
	private List<BoardDto> getBoardList(Model model) throws Exception {
		
		List<BoardDto> results = boardservice.getBoardList();

		return results;
		
	}
	
	@GetMapping("/board/detail")
	private String openDetail(@RequestParam("idx") int idx, Model model) throws Exception{
		
		BoardDto boardDto = new BoardDto();
		boardDto.setIdx(idx);
		BoardDto result = boardservice.getContentByidx(boardDto);
		model.addAttribute("board", result);
		System.out.println("r결과값: ");
		System.out.println(result);
		return "boarddetail";
	}

}
