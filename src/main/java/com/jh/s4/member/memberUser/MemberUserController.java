package com.jh.s4.member.memberUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jh.s4.member.MemberDTO;

@Controller
@RequestMapping("/member/**")
public class MemberUserController {

	@Autowired
	private MemberUserService memberUserService; 
	
	//getMemberLogin
	@GetMapping("memberLogin")
	public ModelAndView getMemberLogin() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/memberLogin");
		
		return mv;	
		
	}
	
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberDTO memberDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		memberDTO = memberUserService.getMemberLogin(memberDTO);
		
		return mv;	
		
	}
}
