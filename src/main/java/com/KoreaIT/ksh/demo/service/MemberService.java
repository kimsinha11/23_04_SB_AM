package com.KoreaIT.ksh.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KoreaIT.ksh.demo.repository.MemberRepository;
import com.KoreaIT.ksh.demo.vo.Member;

@Service
public class MemberService {

	@Autowired // 자동연결
	private MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}


	public int doJoin(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNum) {
		Member existmember = getMemberByLoginId(loginId);
		if(existmember != null) {
			return -1;
		}
		memberRepository.doJoin(loginId, loginPw, name, nickname, email, cellphoneNum);
		return memberRepository.getLastInsertId();
		
	}


	private Member getMemberByLoginId(String loginId) {
		// TODO Auto-generated method stub
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
