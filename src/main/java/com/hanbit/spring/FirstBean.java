package com.hanbit.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class FirstBean {
	
	private int result;

	public int plus(int x, int y) {
		
		result = x + y;
		
		return result;
	}
	
	public int getResult() {
		return result;
	}

	@PostConstruct
	public void initialize() throws Exception {
		System.out.println("First Bean init");		
	}

	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("First Bean destroy");		
	}
	
}






