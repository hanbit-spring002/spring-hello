package com.hanbit.spring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FourthBean {

	@Resource(name="thirdBean")
	private ThirdBean thirdBean;
	
	public void print() {
		thirdBean.printCalc(7, 8);
	}
	
}
