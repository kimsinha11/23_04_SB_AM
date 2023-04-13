package com.KoreaIT.ksh.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Data;

@Controller
public class UsrHomeController {
	
	@RequestMapping("/usr/home/getInt")
	@ResponseBody
	public int getInt() {
	
		return 22;
	}
	@RequestMapping("/usr/home/getString")
	@ResponseBody
	public String getString() {
	
		return "2";
	}
	@RequestMapping("/usr/home/getDouble")
	@ResponseBody
	public double getDouble() {
	
		return 2.234;
	}
	@RequestMapping("/usr/home/getFloat")
	@ResponseBody
	public float getFloat() {
		
		return 2.234f;
	}
	@RequestMapping("/usr/home/getBoolean")
	@ResponseBody
	public boolean getBoolean() {
		
		return true;
	}
	@RequestMapping("/usr/home/getChar")
	@ResponseBody
	public char getChar() {
		
		return 'a';
	}
	
	
	@RequestMapping("/usr/home/getMap")
	@ResponseBody
	public Map<String, Object> getMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("신하나이", 25);
		map.put("동연나이", 27);
		map.put("용준나이", 28);
		return map;
	}
}

//	@RequestMapping("/usr/home/getList")
//	@ResponseBody
//	public List<String> getList() {
//		List<String> list = new ArrayList<>();
//		list.add("동연나이");
//		list.add("용준나이");
//		list.add("신하나이");
//		return list;
//	}
//	
//	@RequestMapping("/usr/home/getArticle")
//	@ResponseBody
//	public Article getArticle() {
//		Article article = new Article(1, "제목1", "내용1");
//		
//		return article;
//	}
//	@RequestMapping("/usr/home/getArticles")
//	@ResponseBody
//	public List<Article> getArticles() {
//		Article article1 = new Article(1, "제목1", "내용1");
//		Article article2 = new Article(2, "제목2", "내용2");
//		
//		List<Article> articles = new ArrayList<>();
//		articles.add(article1);
//		articles.add(article2);
//		return articles;
//	}
//
//} 
//@Data
//@AllArgsConstructor
//class Article {
//
//	private int id;
//	private String title;
//	private String body;
//	
//}
