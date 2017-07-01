package com.hanbit.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String hello() {
		return "hello"; //     WEB-INF/jsp/hello.jsp
	}
	
}
