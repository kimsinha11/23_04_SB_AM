package com.KoreaIT.ksh.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KoreaIT.ksh.demo.repository.MemberRepository;
import com.KoreaIT.ksh.demo.util.Ut;
import com.KoreaIT.ksh.demo.vo.Member;
import com.KoreaIT.ksh.demo.vo.ResultData;

@Service
public class MemberService {

	@Autowired // 자동연결
	private MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}


	public ResultData doJoin(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNum) {
		// 로그인 아이디 중복체크
		Member existmember = getMemberByLoginId(loginId);
		if(existmember != null) {
			return ResultData.from("F-7", Ut.f("이미 사용중인 아이디(%s)입니다.", loginId));
		}
		// 이름+이메일 동시체크
		Member existmember2 = getMemberByNamemail(name, email);
		if(existmember2 != null) {
			return ResultData.from("F-8", Ut.f("이미 사용중인 이름(%s), 이메일(%s) 입니다.",  name, email));
		}
		memberRepository.doJoin(loginId, loginPw, name, nickname, email, cellphoneNum);
		int id = memberRepository.getLastInsertId();
		
		return ResultData.from("S-1", "회원가입이 완료되었습니다.", id);
	}


	private Member getMemberByNamemail(String name, String email) {
	
		return memberRepository.getMemberByNamemail(name, email);
	}


	private Member getMemberByLoginId(String loginId) {

		return memberRepository.getMemberByLoginId(loginId);
	}


	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}


	public List<Member> getMembers() {
		return memberRepository.getMembers();
	}


	public Member doLogin(String loginId, String loginPw) {
		return memberRepository.doLogin(loginId, loginPw);
		
	}







}
