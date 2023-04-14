package com.KoreaIT.ksh.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KoreaIT.ksh.demo.repository.ArticleRepository;
import com.KoreaIT.ksh.demo.vo.Article;

@Service
public class ArticleService {

	@Autowired // 자동연결
	private ArticleRepository articleRepository;

	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	public Article getArticleById(int id) {
		return articleRepository.getArticleById(id);
	}

	public int writeArticle(String title, String body) {

		int id = articleRepository.getLastInsertId();
		articleRepository.writeArticle(title, body);
		return articleRepository.getLastInsertId();
		
	}

	public void deleteArticle(int id) {

		articleRepository.deleteArticle(id);
	}

	public void modifyArticle(int id, String title, String body) {

		articleRepository.modifyArticle(id, title, body);
	}

	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}

}
