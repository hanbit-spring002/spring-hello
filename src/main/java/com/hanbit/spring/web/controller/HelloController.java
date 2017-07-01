package com.hanbit.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String hello() {
		return "hello"; //     WEB-INF/jsp/hello.jsp
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public Map json() {
		Map map = new HashMap();
		map.put("name", "Hanbit");
		map.put("data", true);
		
		return map;
	}
	
}









