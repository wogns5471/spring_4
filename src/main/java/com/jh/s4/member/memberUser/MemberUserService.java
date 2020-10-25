package com.jh.s4.member.memberUser;

import org.springframework.stereotype.Service;

import com.jh.s4.member.MemberDTO;
import com.jh.s4.member.MemberService;

@Service
public class MemberUserService implements MemberService {

	private MemberUserDAO memberUserDAO;
	
	@Override
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		
		return memberUserDAO.getMemberLogin(memberDTO);
	}

}
