package com.edu.biz;

import com.edu.beans.*;
import com.dev.dao.MemberDAO;

public class MemberService {

	MemberDAO dao = new MemberDAO();
	
	public void memberInsert(Member member) {
		dao.insertMember(member);
	}
}
