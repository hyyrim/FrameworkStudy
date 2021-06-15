/*==================================
	CalculatorBeforeAdvice.java
	- Before Advice 구성
==================================*/

package com.test.spr;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class CalculatorBeforeAdvice implements MethodBeforeAdvice
{
	
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable
	{
		// 매개변수는 건들지않아도 상관없다.
		// MethodBeforeAdvice 를 implements 하겠다하면 
		// 스프링이 알아서 Before Advice 로 삽입해준다.
		// 여기서 중요한건, 주업무를 실행하기 전에 스프링이 Before Advice 를 만들어준다는 것.
		// 물론 만들어졌으면 이 클래스를 기반으로 스프링이 객체를 운용할 수 있게끔 해줘야함.
		
		Log log = LogFactory.getLog(this.getClass());
		log.info("Before Advice 실행--------------------");
		log.info("주 업무 실행 전에 수행되어야 하는 작업");
		log.info("Before Advice 실행--------------------");
		
		
		
	}
	
}
