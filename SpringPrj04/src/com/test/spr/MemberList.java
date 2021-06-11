/*========================================
	MemberList.java
	- DAO 클래스를 참조하는 클래스
	- 의존관계 설정
	- print() 메소드 구현
========================================*/

package com.test.spr;

public class MemberList
{
	
	// 스프링 IoC/DI 패턴 적용
	// 멤버 변수 추가하는 과정에서 데이터 타입은 인터페이스 형식
	private IDAO dao;
	// Oracle 이나 Mssql 타입이면 안된다.

	// setter 메소드 추가
	public void setDao(IDAO dao) // 넘겨받는 매개변수도 인터페이스 형식
	{
		this.dao = dao;
	}

	// print() 메소드 구현(수정할 필요 없음. 그대로 사용)
	public void print()
	{
		try
		{
			for (MemberDTO dto : dao.list())
			{
				System.out.printf("%10s %4s %15s %12s%n"
						, dto.getId(), dto.getName()
						, dto.getTel(), dto.getEmail());
			}
			
		} catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
	}
}
