/*==============================================
	Main.java
	- main() 메소드가 포함된 테스트 클래스
==============================================*/

package com.test.spr;

import java.lang.reflect.Proxy;

public class Main
{

	public static void main(String[] args)
	{
		// 주 업무 실행을 할 수 있는 객체 준비
		// 인터페이스 변수 = new 인터페이스구현클래스();
		Calculator cal = new CalculatorImpl();
		// List list = new ArrayList();
		
		/*
		// 주 업무 실행에 대한 테스트(AOP 기법을 적용하기 전 코드)
		int add = cal.add(10, 20);
		System.out.println(add);
		
		int sub = cal.sub(10, 20);
		System.out.println(sub);
		
		int multi = cal.multi(10, 20);
		System.out.println(multi);
		
		int div = cal.div(10, 20);
		System.out.println(div);
		*/
		
		// 주 업무 실행에 대한 테스트(AOP 기법 적용 후)
		
		// Proxy.newProxyInstance(loader, interfaces, h)
		// loader → 주 업무를 실행하는 클래스에 대한 정보 전달(제공)
		// interfaces →주 업무 실행 클래스의 인터페이스에 대한 정보 전달
		// h → 보조 업무 실행 클래스에 대한 정보 전달
		
		Calculator proxy = (Calculator)Proxy.newProxyInstance(cal.getClass().getClassLoader()
							 , cal.getClass().getInterfaces()
							 , new CalculatorProxy(cal));
		// => Object 반환
		// 주 업무를 하는 척 하는 객체 반환하는 것
		// 하지만 클라이언트는 요청이 처리만 된다면 누가 처리하든 상관없다.
		
		// ① Parameter
		// cal.getClass()    : 클래스 정보가 메모리에 올라가고 
		// .getClassLoader() : → 주 업무에 수행하는 클래스를 읽어드리게끔한다.
		// 설계도를 넘긴것
		
		// ②  Parameter
		// cal.getClass().getInterfaces() : implements 하고있는 인터페이스의 정보가 넘어간다.
		// 여러개의 인터페이스를 implements 하고있다면 여러개가 다 넘어간다.
		
		// ③ Parameter
		// 보조 업무 실행 클래스에 대한 정보 전달
		// 매개변수로 되고싶은 객체(target) 넘기면서 → CalculatorProxy 에 생성자 호출
		// target으로 기본 정보 설정됨 
		
		int add = proxy.add(10, 20);
		System.out.println(add);
		
		int sub = proxy.sub(10, 20);
		System.out.println(sub);
		
		int multi = proxy.multi(10, 20);
		System.out.println(multi);
		
		int div = proxy.div(10, 20);
		System.out.println(div);
		
		// proxy 는 사실 Calculator 가 아닌데 
		// proxy 가 Calculator인 척 Calculator의 메소드를 대신 쓸 수 있다.
		
	}

}
