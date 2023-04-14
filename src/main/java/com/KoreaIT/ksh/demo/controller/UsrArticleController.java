package com.KoreaIT.ksh.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KoreaIT.ksh.demo.service.ArticleService;
import com.KoreaIT.ksh.demo.vo.Article;

@Controller
public class UsrArticleController {
	
	@Autowired // 자동연결 
	private ArticleService articleService;
	
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {

		Article article = articleService.getArticleById(id);

		if (article == null) {
			return id + "번글은 존재하지 않습니다.";
		} else {
			articleService.deleteArticle(id);
			return id + "번글이 삭제되었습니다.";
		}
	}

	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public Object getArticle(int id) {

		Article article = articleService.getArticleById(id);

		if (article == null) {
			return id + "번글은 존재하지 않습니다.";
		}
		
		return article;
	}


	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public Object doModify(int id, String title, String body) {

		Article article = articleService.getArticleById(id);

		if (article == null) {
			return id + "번글은 존재하지 않습니다.";
		}
		articleService.modifyArticle(id, title, body);

		return id + "번글이 수정되었습니다." + article;

	}

	@RequestMapping("/usr/article/doWrite")
	@ResponseBody
	public Article doWrite(String title, String body) {

		int id = articleService.writeArticle(title, body);
		Article article = articleService.getArticleById(id);
		
		return article;
	}

	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {

		return articleService.getArticles();
	}

}
