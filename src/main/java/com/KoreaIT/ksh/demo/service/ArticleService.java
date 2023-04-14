package com.KoreaIT.ksh.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.KoreaIT.ksh.demo.vo.Article;

@Service
public class ArticleService {
	public List<Article> articles;
	 private int lastArticleId;

	// 생성자메서드
	public ArticleService() {
		lastArticleId = 0;
		articles = new ArrayList<>();
		makeTestData();
	}

	public Article getArticleById(int id) {
		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);

			if (article.getId() == id) {
				return article;
			}
		}

		return null;
	}

	public Article writeArticle(String title, String body) {
		int id = lastArticleId + 1;
		Article article = new Article(id, title, body);

		articles.add(article);
		lastArticleId++;
		return article;
	}



	public void deleteArticle(int id) {
		Article article = getArticleById(id);
		articles.remove(article);
	}

	public void modifyArticle(int id, String title, String body) {
		Article article = getArticleById(id);
		article.setTitle(title);
		article.setBody(body);
	}

	private void makeTestData() {
		for (int i = 1; i <= 10; i++) {
			String title = "제목" + i;
			String body = "내용" + i;

			writeArticle(title, body);
		}
	}

}

