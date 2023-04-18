package com.KoreaIT.ksh.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KoreaIT.ksh.demo.service.MemberService;
import com.KoreaIT.ksh.demo.util.Ut;
import com.KoreaIT.ksh.demo.vo.Member;
import com.KoreaIT.ksh.demo.vo.ResultData;

@Controller
public class UsrMemberController {
	
	@Autowired // 자동연결 
	private MemberService memberService;
	

	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public ResultData doJoin(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNum) {

		
		if(Ut.empty(loginId)) {
			return ResultData.from("F-1", Ut.f("아이디를 입력해주세요"));
		}
		if(Ut.empty(loginPw)) {
			return ResultData.from("F-2", Ut.f("비밀번호를 입력해주세요"));
		}
		if(Ut.empty(name)) {
			return ResultData.from("F-3", Ut.f("이름을 입력해주세요"));
		}
		if(Ut.empty(nickname)) {
			return ResultData.from("F-4", Ut.f("닉네임을 입력해주세요"));
		}
		if(Ut.empty(email)) {
			return ResultData.from("F-5", Ut.f("이메일을 입력해주세요"));
		}
		if(Ut.empty(cellphoneNum)) {
			return ResultData.from("F-6", Ut.f("전화번호를 입력해주세요"));
		}
		
		ResultData doJoinRd = memberService.doJoin(loginId, loginPw, name, nickname, email, cellphoneNum);

		if(doJoinRd.isFail()) {
			return doJoinRd;
		}
		
		Member member = memberService.getMemberById((int) doJoinRd.getData1());

		return ResultData.newData(doJoinRd, member);
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
	
//	@RequestMapping("/usr/member/doLeave")
//	@ResponseBody
//	public String doLeave(String loginId, String loginPw) {
//
//		Member member = memberService.doLogin(loginId, loginPw);
//
//		if (member == null) {
//			return loginId + "는 존재하지 않는 아이디입니다.";
//		}
//		if (member.getLoginPw().equals(loginPw)==false) {
//			return "비밀번호가 틀렸습니다.";
//		}
//		return "로그인 성공!";
//	}
//	
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
