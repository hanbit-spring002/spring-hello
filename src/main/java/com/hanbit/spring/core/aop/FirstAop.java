package com.hanbit.spring.core.aop;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.hanbit.spring.core.annotation.SampleAnnotion;
import com.hanbit.spring.core.vo.ArticleVO;

@Component
@Aspect
public class FirstAop {

	private static final Logger LOGGER = LoggerFactory.getLogger(FirstAop.class);

	@Pointcut("execution(public * com.hanbit..HelloService.*(..))")
	public void pointCutHello() {
		
	}
	
	@Pointcut("execution(public * com.hanbit..BoardService.*(..))")
	public void pointCutBoard() {
		
	}
	
	/*@AfterThrowing(value="pointCutBoard()",
			throwing="e")
	public void logAfeterBoardError(Throwable e) {
		LOGGER.error(e.getMessage());
	}
	
	@AfterReturning(value="pointCutBoard() || pointCutHello()",
			returning="ret")
	public void logAfterBoardService(Object ret) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			String json = mapper.writeValueAsString(ret);
			LOGGER.debug(json);
		}
		catch (JsonProcessingException e) {
			
		}
		LOGGER.debug("board or hello service called");
	}
	
	@Before("pointCutHello()")
	public void logAfterHelloService() {
		LOGGER.debug("hello service will be called");
	}*/
	
	/*@Around("pointCutBoard()")
	public Object aroundBoardService(ProceedingJoinPoint pjp) {
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();
		SampleAnnotion annotion = method.getAnnotation(SampleAnnotion.class);
		
		LOGGER.debug(annotion.value());
		// Before
		try {
			Object ret = pjp.proceed();

			if (ret instanceof List) {
				List<ArticleVO> list = (List<ArticleVO>) ret;
				ArticleVO fakeArticle = new ArticleVO();
				fakeArticle.setTitle("가짜글");
				fakeArticle.setNo(0);
				fakeArticle.setViews(152);
				fakeArticle.setUpdateDt("지금");
				
				list.add(fakeArticle);
			}
			
			return ret;
		}
		catch (Throwable e) {
			// AfterThrowing
			throw new RuntimeException("점검 시간입니다.");
		}
	}*/
	
}









