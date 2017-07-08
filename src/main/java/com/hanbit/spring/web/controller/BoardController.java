package com.hanbit.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanbit.spring.core.service.BoardService;
import com.hanbit.spring.core.vo.ArticleVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@RequestMapping("/")
	public String list(Model model) {
		model.addAttribute("list", boardService.getList());
		
		return "board/list";
	}
	
	@RequestMapping("/api/list")
	@ResponseBody
	public List<ArticleVO> apiList() {
		return boardService.getList();
	}
	
}







