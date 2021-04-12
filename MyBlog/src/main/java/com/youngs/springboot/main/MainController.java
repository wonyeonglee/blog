package com.youngs.springboot.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	private String main(Model model) {
		return "index";
	}
	
	

}
