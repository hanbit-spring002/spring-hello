package com.hanbit.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hanbit.spring.FirstBean;
import com.hanbit.spring.SecondBean;
import com.hanbit.spring.ThirdBean;

@Configuration
@ComponentScan(basePackages={"com.hanbit.spring"})
public class JavaConfig {

	@Bean
	public FirstBean firstBean() {
		return new FirstBean();
	}
	
	@Bean
	public ThirdBean thirdBean(FirstBean firstBean,
			SecondBean secondBean) {
		
		ThirdBean thirdBean = new ThirdBean();
		thirdBean.setFirstBean(firstBean);
		thirdBean.setSecondBean(secondBean);
		thirdBean.setName("세번째빈 by Java");
		
		return thirdBean;
	}
	
}










