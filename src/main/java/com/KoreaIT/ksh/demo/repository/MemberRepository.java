package com.KoreaIT.ksh.demo.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.KoreaIT.ksh.demo.vo.Member;

@Mapper
public interface MemberRepository {

	public int doJoin(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNum);

	public int getLastInsertId();

	public Member getMemberById(int id);

	public List<Member> getMembers();

	public Member doLogin(String loginId, String loginPw);

	public Member getMemberByLoginId(String loginId);

	public Member getMemberByNamemail(String name, String email);





}
