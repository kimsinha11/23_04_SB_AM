package com.KoreaIT.ksh.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KoreaIT.ksh.demo.service.MemberService;
import com.KoreaIT.ksh.demo.vo.Article;
import com.KoreaIT.ksh.demo.vo.Member;

@Controller
public class UsrMemberController {
	
	@Autowired // 자동연결 
	private MemberService memberService;
	

	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public String doJoin(LocalDateTime regDate, LocalDateTime updateDate, String loginId, String loginPw, String name, String nickname, String email, String cellphoneNum) {

		int id = memberService.doJoin(regDate, updateDate, loginId, loginPw, name, nickname, email, cellphoneNum);

		return "가입!";
	}

	@RequestMapping("/usr/member/memberProfile")
	@ResponseBody
	public Object getMemberById(int id) {

		Member member = memberService.getMemberById(id);

		if (member == null) {
			return id + "번 회원은 존재하지 않습니다.";
		}
		
		return member;
	}
	
	@RequestMapping("/usr/member/getMembers")
	@ResponseBody
	public List<Member> getMembers() {

		return memberService.getMembers();
	}

}
