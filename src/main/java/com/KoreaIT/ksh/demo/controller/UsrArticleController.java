package com.KoreaIT.ksh.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KoreaIT.ksh.demo.vo.Article;

@Controller
public class UsrArticleController {
	List<Article> articles;
	int lastArticleId;
	
	public UsrArticleController() {
		lastArticleId = 0;
		articles = new ArrayList<>();
	}
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public String doAdd(String title, String body) {
		int id = lastArticleId+1;
		Article article = new Article(id, title, body);
		
		articles.add(article);
		lastArticleId++;
		return id + "번 글이 생성되었습니다.";
	}
	
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		
		return articles;
	}
	

} 
