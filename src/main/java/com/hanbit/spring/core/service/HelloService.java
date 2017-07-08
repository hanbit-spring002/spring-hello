package com.hanbit.spring.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.spring.core.dao.HelloDAO;

@Service
public class HelloService {

	@Autowired
	private HelloDAO helloDAO;
	
}
