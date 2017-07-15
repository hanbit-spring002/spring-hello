package com.hanbit.spring.web.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {

	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public String signin(HttpSession session,
			HttpServletResponse res) throws Exception {
		Boolean signedIn = (Boolean) session.getAttribute("signedIn");
		
		if (signedIn != null && signedIn) {
			res.sendRedirect("/");
			return null;
		}
		
		return "signin";
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public void doSignin(@RequestParam("email") String email,
			@RequestParam("passwd") String passwd,
			HttpSession session,
			HttpServletResponse res) throws Exception {
		
		if ("abcd@abcd.com".equals(email) && "1234".equals(passwd)) {
			session.setAttribute("signedIn", true);
			session.setAttribute("email", email);
			session.setAttribute("role", "USER");
			
			res.sendRedirect("/");
		}
		else if ("ceo@abcd.com".equals(email) && "1234".equals(passwd)) {
			session.setAttribute("signedIn", true);
			session.setAttribute("email", email);
			session.setAttribute("role", "CEO");
			
			res.sendRedirect("/");
		}
		else {
			res.sendRedirect("/signin?msg=wrong");
		}
	}
	
	@RequestMapping("/signout")
	public void doSignout(HttpSession session,
			HttpServletResponse res) throws Exception {
		session.invalidate();
		
		res.sendRedirect("/signin");
	}
}









