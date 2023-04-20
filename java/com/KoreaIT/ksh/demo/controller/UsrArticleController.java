package com.KoreaIT.ksh.demo.controller;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KoreaIT.ksh.demo.service.ArticleService;
import com.KoreaIT.ksh.demo.util.Ut;
import com.KoreaIT.ksh.demo.vo.Article;
import com.KoreaIT.ksh.demo.vo.ResultData;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class UsrArticleController {


	@Autowired
	private ArticleService articleService;
	
	// 액션메서드
	@RequestMapping("/usr/article/modify")
	@ResponseBody
	public ResultData<Integer> doModify(HttpSession httpSession, int id, String title, String body) {
		boolean isLogined = false;
		int loginedMemberId = 0;

		if (httpSession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId = (int) httpSession.getAttribute("loginedMemberId");
		}

		if (isLogined == false) {
			return ResultData.from("F-A", "로그인 후 이용해주세요");
		}

		Article article = articleService.getArticle(id);
		if (article == null) {
			return ResultData.from("F-1", Ut.f("%d번 글은 존재하지 않습니다", id), "id", id);
		}

		ResultData actorCanModifyRd = articleService.actorCanModify(loginedMemberId, article);

		if (actorCanModifyRd.isFail()) {
			return actorCanModifyRd;
		}

		return articleService.modifyArticle(id, title, body);

	}

	@RequestMapping("/usr/article/delete")
	public String doDelete(Model model, HttpSession httpSession, int id) {
		
		boolean isLogined = false;

		if (httpSession.getAttribute("loginedMemberId") != null) {
			isLogined = true;

		}
		if (isLogined == false) {
			return String.format("<script>alert('로그인 후 이용해주세요.'); location.replace('../article/detail');</script>");
		} 
		

		Article article = articleService.getArticle(id);
		if(article.getMemberId()==(int) httpSession.getAttribute("loginedMemberId")) {

		articleService.deleteArticle(id);
		
		model.addAttribute("article",article);
		return "usr/article/list";
		} else {
			return String.format("<script>alert('권한이 없습니다..'); location.replace('usr/article/detail');</script>");
		}
	}


	@RequestMapping("/usr/article/doWrite")
	@ResponseBody
	public ResultData<Article> doWrite(HttpSession httpsession,String title, String body) {
		
		boolean isLogined = false;
		int loginedMemberId =0 ;
		
		if (httpsession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId = (int) httpsession.getAttribute("loginedMemberId");
		}
		if (isLogined == false) {
			return ResultData.from("F-A", "로그인 후 이용해주세요");
		}
		
		if (Ut.empty(title)) {
			return ResultData.from("F-1", "제목을 입력해주세요");
		}
		if (Ut.empty(body)) {
			return ResultData.from("F-2", "내용을 입력해주세요");
		}

		ResultData<Integer> writeArticleRd = articleService.writeArticle(title, body, loginedMemberId);

		int id = (int) writeArticleRd.getData1();

		Article article = articleService.getArticle(id);

		return ResultData.newData(writeArticleRd,"article", article);
	}

	@RequestMapping("/usr/article/list")
	public String showList(Model model) {
		List<Article> articles = articleService.articles();
		
		model.addAttribute("articles", articles);
		
		return "usr/article/list";
	}

	@RequestMapping("/usr/article/detail")
	public String getArticle(Model model,HttpSession httpsession, int id) {
		boolean isLogined = false;
		int loginedMemberId =0 ;
		
		if (httpsession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId = (int) httpsession.getAttribute("loginedMemberId");
		}
		
		Article article = articleService.getArticle(id);

		if (article == null) {
			return id +"번 게시물은 존재하지 않습니다.";
		}
		
		model.addAttribute("article",article);
		model.addAttribute("isLogined",isLogined);
		
		return "usr/article/detail";
	}

}