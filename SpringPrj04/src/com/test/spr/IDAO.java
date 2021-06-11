/*===================
	IDAO.java
	- 인터페이스
===================*/

package com.test.spr;

import java.sql.SQLException;
import java.util.List;

public interface IDAO
{
	public List<MemberDTO> list() throws ClassNotFoundException, SQLException;
	// 메소드 오버라이딩 할 때 예외처리를 추가할 수 없기 때문에
	// 미리 추가해준다.
}
