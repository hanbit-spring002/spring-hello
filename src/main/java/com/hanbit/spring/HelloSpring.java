package com.hanbit.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hanbit.spring.config.JavaConfig;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context
			// = new ClassPathXmlApplicationContext("spring/context.xml");
			= new AnnotationConfigApplicationContext(JavaConfig.class);
		
		FirstBean firstBean = context.getBean("firstBean", FirstBean.class);
		System.out.println(firstBean.plus(3, 5));
		
		SecondBean secondBean = (SecondBean) context.getBean("secondBean");
		System.out.println(secondBean.minus(5, 3));
		
		ThirdBean thirdBean = context.getBean(ThirdBean.class);
		thirdBean.printCalc(4, 8);
		System.out.println(thirdBean.getName());
		
		FourthBean fourthBean = (FourthBean) context.getBean("fourthBean");
		fourthBean.print();
	}
	
}









