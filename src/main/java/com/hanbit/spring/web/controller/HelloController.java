package com.hanbit.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanbit.spring.core.service.HelloService;

@Controller
public class HelloController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	private HelloService helloService;
	
	@RequestMapping(value="/dual/{id}",
			method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Map dual(@RequestParam("no") int num,
			@PathVariable("id") int id) {
		LOGGER.debug("no=" + num);
		LOGGER.debug("id=" + id);
		
		Map<String, Integer> result = new HashMap<>();
		result.put("result", helloService.getDual(num));
		
		return result;
	}

	@RequestMapping("/hello")
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









