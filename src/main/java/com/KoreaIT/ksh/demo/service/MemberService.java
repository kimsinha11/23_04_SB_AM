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


	public int doJoin(LocalDateTime regDate, LocalDateTime updateDate, String loginId, String loginPw, String name, String nickname, String email, String cellphoneNum) {

		int id = memberRepository.getLastInsertId();
		memberRepository.doJoin(regDate, updateDate, loginId, loginPw, name, nickname, email, cellphoneNum);
		return memberRepository.getLastInsertId();
		
	}


	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}


	public List<Member> getMembers() {
		return memberRepository.getMembers();
	}


}
