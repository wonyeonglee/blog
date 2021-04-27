package com.youngs.springboot.Board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		return "boarddetail";
	}
	
	@GetMapping("/board/write")
	private String openWrite(Model model) throws Exception{
		return "write";
	}
	
	@PostMapping("/board/write")
	private String insertData(Model model, @RequestParam("title") String title, @RequestParam("writer") String writer, @RequestParam("password") String password,
			@RequestParam("content") String content) throws Exception{
		BoardDto boardDto = new BoardDto();
		boardDto.setTitle(title);
		boardDto.setWriter(writer);
		boardDto.setPassword(password);
		boardDto.setContent(content);
		System.out.println("들어온값");
		System.out.println(boardDto);
		boardservice.insertContent(boardDto);
		
		return "redirect:/board";
	}

}
