package com.hanbit.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	@RequestMapping("/")
	public String list() {
		return "board/list";
	}
	
}
