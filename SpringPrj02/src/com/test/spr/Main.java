/*==============================================
	Main.java
	- main() 메소드가 포함된 테스트 클래스
==============================================*/

package com.test.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
	public static void main(String[] args)
	{
		// [스프링이 처리하고 관리하게 될 영역]
		//------------------------------------------------------------------
		/*
		// ① RecordImpl1(Record) 객체 생성 과정
		Record rec1 = new RecordImpl1();		//-- dependency (의존 객체)
		
		// ② RecordImpl2(Record) 객체 생성 과정
		Record rec2 = new RecordImpl2();		//-- dependency (의존 객체)
		
		// RecordViewImpl(RecordView) 객체 생성 과정
		//-- Record 객체(의존 객체 - RecordImpl1 or RecordImpl2) 필요
		RecordView view = new RecordViewImpl();
		
		// 의존 객체 주입
		//-- 의존 객체 주입 방법을 사용하게 되면
		//	 느슨한 결합을 구성할 수 있게 되고(유연성 향상)
		//	 한 쪽의 변동 상황이 다른 쪽에 영향을 덜 줄 수 있게 된다.
		view.setRecord(rec2);					//-- setter injection
												//	 (setter 를 통한 주입)
		*/
		
		//------------------------------------------------------------------
		
		// ※ 스프링 프레임워크에서는
		//	  객체 생성 과정 및 DI(의존 객체 주입)에 대한 설정은
		//	  스프링 환경 설정 파일로 대체된다. (→ applicationContext.xml)
		
		// 스프링 프레임워크에서 『applicationContext.xml』 파일을 읽어서
		// 생성 및 관리할 객체에 대한 정보를 얻어야 한다.
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 『getBean()』 메소드를 이용하여 사용자가 원하는 객체를 얻는다.
		// 메소드 인자값으로 id 속성값을 지정하게 된다.
		//RecordView view = (RecordViewImpl)context.getBean("view");
		// context.getBean 해오면 Object 로 반환하기 때문에 RecordViewImpl로 다운캐스팅
		// ※ bean 메소드는 Object 를 반환한다.
		
		// 안정성을 위해 아래 코드 사용 가능
		
		// 스프링 3.0 이후 버전부터 사용 가능한 코드
		RecordView view = context.getBean("view", RecordViewImpl.class);
		
		view.input();
		view.output();
	}	

	
}
