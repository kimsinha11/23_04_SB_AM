package com.KoreaIT.ksh.demo.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.KoreaIT.ksh.demo.vo.Article;
import com.KoreaIT.ksh.demo.vo.Member;

@Mapper
public interface MemberRepository {

	public void doJoin(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNum);

	public int getLastInsertId();

	public Member getMemberById(int id);

	public List<Member> getMembers();

}
