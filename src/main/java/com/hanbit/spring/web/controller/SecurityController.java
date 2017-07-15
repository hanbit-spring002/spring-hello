package com.hanbit.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@RequestMapping("/signin")
	public String signin() {
		return "signin";
	}
	
}
