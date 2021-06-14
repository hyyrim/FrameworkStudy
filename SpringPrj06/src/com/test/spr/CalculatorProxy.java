/*==============================================
	CalculatorProxy.java
	- 프록시 클래스
	- 보조 업무 적용 및 주 업무 호출 과정
==============================================*/

package com.test.spr;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

// ※ Proxy 클래스를 만드는 방법 중 비교적 쉽고 직관적인 방법은
//	  InvocationHandler 인터페이스를 구현하는 클래스를 만드는 것이다.

public class CalculatorProxy implements InvocationHandler
{
	private Object target;
	
	// 생성자 정의
	// 매개변수 target을 받아 기본 설정해주기
	public CalculatorProxy(Object target)
	{
		this.target = target;
		// 여기서 target 은 따라 되고싶은 객체를 말한다.
		// 이런 애가 되고싶어
	}
	
	// 보조 업무 적용 및 주 업무 호출 과정 추가
	@Override
				// 사용법만 알면된다.. 분해해서 볼 필요는 없음
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{		///나 이게 되고싶어, 그렇게 되려면 필요한 설계도, 추가 필요 사항
		
		// 보조 업무(cross-cutting concern) 설정
		//-- 시간 측정(Around Advice)
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("처리 시간 측정 시작------------------"); // 콘솔에 찍히게 되는 내용
		
		// 주 업무(core concern) 실행 내용
		Object result = method.invoke(target, args);
		// args → 객체가 가지고 있는 주변 속성들
		
		sw.stop();
		log.info("처리 시간 측정 종료------------------");
		log.info(String.format("경과시간 : %s/1000초", sw.getTotalTimeMillis()));
		// Long 형으로 반환 → %f 로 수신하거나 %s(문자열)로 수신해도 상관 없다.
		
		return result;
		
	}
	
	
}




