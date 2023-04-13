package com.KoreaIT.ksh.demo.vo;

import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Article {
	private int id;
	private String title;
	private String body;

}
