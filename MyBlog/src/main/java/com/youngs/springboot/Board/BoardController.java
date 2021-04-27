package com.youngs.springboot.Board;

import java.util.List;
import java.util.Objects;

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
		model.addAttribute("message",0);
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
		boardservice.insertContent(boardDto);
		
		return "board";
	}
	@GetMapping("/board/delete")
	private String openDelete(@RequestParam("idx") int idx, Model model) throws Exception{
		model.addAttribute("idx", idx);
		return "delete";
	}
	
	@PostMapping("/board/delete")
	private String deleteByIdx(@RequestParam("idx") int idx, @RequestParam("password") String password, Model model) throws Exception{
		//idx가 idx인 데이터의 password가 맞는지 check
		BoardDto boardDto = new BoardDto();
		boardDto.setIdx(idx);
		BoardDto result = boardservice.getContentByidx(boardDto);

		if(password.equals(result.getPassword())) {//비밀번호가 일치하면 왜 false가 나오냐..
			//delete_yn 을 Y로 업데이트하고 글목록창으로 redirect
			boardservice.updateDeleteYn(boardDto);
			System.out.println("비밀번호 일치 o");
			return "/board";
		}
		else {//비밀번호가 일치하지않으면 상세 목록창으로 다시 간다 그리고 alert 비밀번호가 일치하지않다고
			model.addAttribute("message",1);
			System.out.println("비밀번호 일치 X");
			//redirect하면 model.addattribute가 안되는것같다. 그럼 어떻게 alert주지..
			return "/board";
		}
	}

}
