package com.KoreaIT.ksh.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.KoreaIT.ksh.demo.vo.Article;

@Component
public class ArticleRepository {
	

	public List<Article> articles;
	private int lastArticleId;

	public ArticleRepository() {
		
		lastArticleId = 0;
		articles = new ArrayList<>();
		makeTestData();
	
	}
	public void makeTestData() {
		for (int i = 1; i <= 10; i++) {
			String title = "제목" + i;
			String body = "내용" + i;

			writeArticle(title, body);
		}
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



	public void deleteArticle(int id) {
		Article article = getArticleById(id);
		articles.remove(article);

	}

	public void modifyArticle(int id, String title, String body) {
		Article article = getArticleById(id);
		article.setTitle(title);
		article.setBody(body);
	}

	public Article writeArticle(String title, String body) {
		int id = lastArticleId + 1;
		Article article = new Article(id, title, body);

		articles.add(article);
		lastArticleId++;
		return article;
		
	}
	public List<Article> getArticles() {
		return articles;
	}
	
	

}
