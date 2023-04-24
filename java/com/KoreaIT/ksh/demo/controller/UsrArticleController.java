package com.KoreaIT.ksh.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KoreaIT.ksh.demo.service.ArticleService;
import com.KoreaIT.ksh.demo.util.Ut;
import com.KoreaIT.ksh.demo.vo.Article;
import com.KoreaIT.ksh.demo.vo.Rq;

@Controller
public class UsrArticleController {

	@Autowired
	private ArticleService articleService;
	
	
	@RequestMapping("/usr/article/modify")

	public String modify(Model model, HttpServletRequest req, int id, String title, String body) {
		Rq rq = (Rq) req.getAttribute("rq");
				

		Article article = articleService.getArticle(id);
		
		if(article == null) {
			return rq.jsHistoryBackOnView(Ut.f("%d번 글은 존재하지 않습니다",id));
		}
		if (article.getMemberId() == rq.getLoginedMemberId()) {

			model.addAttribute("article", article);
			return "usr/article/modify";
		} else {
			return String.format("<script>alert('권한이 없습니다..'); location.replace('list');</script>");
		}

	}

	@RequestMapping("/usr/article/write")

	public String write(Model model, String title, String body) {

		return "usr/article/write";
	}
	
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public String doModify(int id, String title, String body) {

		articleService.modifyArticle(id, title, body);

		return Ut.jsReplace("S-1", "수정되었습니다", "list");

	}

	@RequestMapping("/usr/article/doWrite")
	@ResponseBody
	public String doWrite(HttpServletRequest req, HttpSession httpSession, String title, String body) {
	
		Rq rq = (Rq) req.getAttribute("rq");
	
		
		if (Ut.empty(title)) {
			return Ut.jsHistoryBack("F-A", "제목을 입력해주세요.");
		}
		if (Ut.empty(body)) {
			return Ut.jsHistoryBack("F-A", "내용을 입력해주세요");
		}
		articleService.writeArticle(title, body, rq.getLoginedMemberId());
		
		
		return String.format("<script>alert('작성되었습니다.'); location.replace('list');</script>");
		
	}
	@RequestMapping("/usr/article/delete")
	@ResponseBody
	public String doDelete(Model model, HttpServletRequest req, int id) {

		Rq rq = (Rq) req.getAttribute("rq");

		Article article = articleService.getArticle(id);
		if (article == null) {
			return Ut.jsHistoryBack("F-D", id + "번 글은 존재하지 않습니다.");
		}

		if (article.getMemberId() == rq.getLoginedMemberId()) {
			articleService.deleteArticle(id);
			model.addAttribute("article", article);
			return  String.format("<script>alert('삭제되었습니다.'); location.replace('list');</script>");
		} else {
			return Ut.jsHistoryBack("F-C", "권한이 없습니다.");
		}
	}
	


	@RequestMapping("/usr/article/list")
	public String showList(Model model) {
		List<Article> articles = articleService.articles();

		model.addAttribute("articles", articles);

		return "usr/article/list";
	}

	@RequestMapping("/usr/article/detail")
	public String getArticle(Model model, HttpServletRequest req, int id) {
		
		Rq rq = (Rq) req.getAttribute("rq");
		
		Article article = articleService.getArticle(id);

		if (article == null) {
			return id + "번 게시물은 존재하지 않습니다.";
		}

		model.addAttribute("article", article);
		model.addAttribute("loginedMemberId", rq.getLoginedMemberId());

		return "usr/article/detail";
	}

}