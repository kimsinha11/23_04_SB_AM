package com.KoreaIT.ksh.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Member {
	private int id;
	private String loginId;
	private String loginPw;
	private String name;
	private String nickname;
	private String email;
	private String cellphoneNum;
	
}
