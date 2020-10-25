package com.jh.s4.member.memberUser;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jh.s4.MyTestCase;
import com.jh.s4.member.MemberDTO;

public class MemberUserDAOTest extends MyTestCase {

	@Autowired
	private MemberUserDAO memberUserDAO;
	
	@Test
	public void getMemberLoginTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id1");
		memberDTO.setPw("pw1");
		memberDTO = memberUserDAO.getMemberLogin(memberDTO);
		
		assertNotNull(memberDTO);
	}

}