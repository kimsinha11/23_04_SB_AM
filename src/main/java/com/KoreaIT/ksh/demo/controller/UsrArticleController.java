package com.KoreaIT.ksh.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KoreaIT.ksh.demo.service.ArticleService;
import com.KoreaIT.ksh.demo.util.Ut;
import com.KoreaIT.ksh.demo.vo.Article;
import com.KoreaIT.ksh.demo.vo.ResultData;

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
	public ResultData getArticle(int id) {

		Article article = articleService.getArticleById(id);

		if (article == null) {
//			return id + "번글은 존재하지 않습니다.";
			return ResultData.from("F-1", Ut.f("%d번 게시물은 존재하지 않습니다.", id));
		}
		
		return ResultData.from("S-1", Ut.f("%d번 게시물입니다.", id), article);
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
	public ResultData doWrite(String title, String body) {
		if(Ut.empty(title)) {
			return ResultData.from("F-1",Ut.f("제목을 입력해주세요"));
		}
		if(Ut.empty(body)) {
			return ResultData.from("F-1",Ut.f("내용을 입력해주세요"));
		}
		ResultData writeArticleRd = articleService.writeArticle(title, body);
		int id = (int) writeArticleRd.getData1();
		Article article = articleService.getArticleById(id);
		
		return ResultData.from(writeArticleRd.getResultCode(),writeArticleRd.getMsg(),article);
	}

	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public ResultData getArticles() {
		ResultData getArticlesRd = articleService.getArticles();
		return ResultData.from(getArticlesRd.getResultCode(), getArticlesRd.getMsg(), getArticlesRd.getData1());
//		return articleService.getArticles();
	}

}
