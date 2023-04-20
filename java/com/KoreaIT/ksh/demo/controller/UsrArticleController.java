package com.KoreaIT.ksh.demo.controller;

import java.util.List;

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

@Controller
public class UsrArticleController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping("/usr/article/modify")

public String modify(Model model, HttpSession httpsession, int id, String title, String body) {
		
		boolean isLogined = false;
	
		if (httpsession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
		}
	
		Article article = articleService.getArticle(id);
		if(article.getMemberId()==(int) httpsession.getAttribute("loginedMemberId")) {

			model.addAttribute("article", article);
			return "usr/article/modify";
			} else {
				return String.format("<script>alert('권한이 없습니다..'); location.replace('list');</script>");
			}

	}

	@RequestMapping("/usr/article/doModify")	
	@ResponseBody
public  String doModify(Model model, int id, String title, String body) {
	
		articleService.modifyArticle(id, title, body);

		return String.format("<script>alert('수정되었습니다.'); location.replace('list');</script>");
	
	}
	@RequestMapping("/usr/article/delete")
	@ResponseBody
	public String doDelete(Model model, HttpSession httpSession, int id) {

		boolean isLogined = false;

		if (httpSession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
		} 
		if(isLogined==false) {
			return Ut.jsHistoryBack("F-A", "로그인 후 이용해주세요.");
		}
		
		Article article = articleService.getArticle(id);
		if (article == null) {
			return Ut.jsHistoryBack("F-D", id + "번 글은 존재하지 않습니다.");
		}
		
		if (article.getMemberId() == (int) httpSession.getAttribute("loginedMemberId")) {
			articleService.deleteArticle(id);
			model.addAttribute("article", article);
			return Ut.jsReplace(Ut.f("삭제되었습니다.", id), "../article/list");
		} else {
			return Ut.jsHistoryBack("F-C", "권한이 없습니다.");
		}
	}

	@RequestMapping("/usr/article/doWrite")
	@ResponseBody
	public ResultData<Article> doWrite(HttpSession httpsession, String title, String body) {

		boolean isLogined = false;
		int loginedMemberId = 0;

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

		return ResultData.newData(writeArticleRd, "article", article);
	}

	@RequestMapping("/usr/article/list")
	public String showList(Model model) {
		List<Article> articles = articleService.articles();

		model.addAttribute("articles", articles);

		return "usr/article/list";
	}

	@RequestMapping("/usr/article/detail")
	public String getArticle(Model model, HttpSession httpsession, int id) {
		boolean isLogined = false;
		int loginedMemberId = 0;

		if (httpsession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId = (int) httpsession.getAttribute("loginedMemberId");
		}

		Article article = articleService.getArticle(id);

		if (article == null) {
			return id + "번 게시물은 존재하지 않습니다.";
		}

		model.addAttribute("article", article);
		model.addAttribute("loginedMemberId", loginedMemberId);

		return "usr/article/detail";
	}

}