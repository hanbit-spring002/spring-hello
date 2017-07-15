package com.hanbit.spring.core.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hanbit.spring.core.annotation.SigninRequired;

@Aspect
@Order(20)
@Component
public class SecurityAspect {

	@Around("@annotation(com.hanbit.spring.core.annotation.SigninRequired)")
	public Object checkSignIn(ProceedingJoinPoint pjp) throws Throwable {
		
		ServletRequestAttributes requestAttributes
			= (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		
		HttpServletRequest req = requestAttributes.getRequest();
		HttpServletResponse res = requestAttributes.getResponse();
		
		HttpSession session = req.getSession();
		
		Boolean signedIn = (Boolean) session.getAttribute("signedIn");
		
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Class returnType = signature.getReturnType();
		
		if (signedIn == null || !signedIn) {
			throw new SecurityException("로그인이 필요합니다.");
		}
		else {
			SigninRequired signinRequired
				= signature.getMethod().getAnnotation(SigninRequired.class);
			
			String[] roles = signinRequired.value();
			String role = (String) session.getAttribute("role");
			
			if (roles.length > 0 && !ArrayUtils.contains(roles, role)) {
				throw new SecurityException("권한이 없습니다.");
			}
		}
		
		return pjp.proceed();
	}
	
}






