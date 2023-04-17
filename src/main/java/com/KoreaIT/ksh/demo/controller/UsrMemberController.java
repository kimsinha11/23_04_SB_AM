package com.KoreaIT.ksh.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KoreaIT.ksh.demo.service.MemberService;
import com.KoreaIT.ksh.demo.vo.Member;

@Controller
public class UsrMemberController {
	
	@Autowired // 자동연결 
	private MemberService memberService;
	

	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public Object doJoin(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNum) {
		if(loginId==null || loginId.trim().length()==0) {
			return "아이디를 입력해주세요";
		}
		if(loginPw==null || loginPw.trim().length()==0) {
			return "비밀번호를 입력해주세요";
		}
		if(name==null || name.trim().length()==0) {
			return "이름을 입력해주세요";
		}
		if(nickname==null || nickname.trim().length()==0) {
			return "닉네임을 입력해주세요";
		}
		if(email==null || email.trim().length()==0) {
			return "이메일을 입력해주세요";
		}
		if(cellphoneNum==null || cellphoneNum.trim().length()==0) {
			return "전화번호를 입력해주세요";
		}
		
		int id = memberService.doJoin(loginId, loginPw, name, nickname, email, cellphoneNum);

		if(id==-1) {
			return "이미 사용중인 아이디입니다.";
		}
		
		Member member = memberService.getMemberById(id);

		return "회원 가입 완료! 회원정보 : " + member;
	}

	@RequestMapping("/usr/member/doLogin")
	@ResponseBody
	public String doLogin(String loginId, String loginPw) {

		Member member = memberService.doLogin(loginId, loginPw);

		if (member == null) {
			return loginId + "는 존재하지 않는 아이디입니다.";
		}
		if (member.getLoginPw().equals(loginPw)==false) {
			return "비밀번호가 틀렸습니다.";
		}
		return "로그인 성공!";
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