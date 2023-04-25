package com.KoreaIT.ksh.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.KoreaIT.ksh.demo.vo.Article;

@Mapper
public interface ArticleRepository {

	public void writeArticle(String title, String body, int memberId);

	public List<Article> getArticles(int boardId);

	public Article getArticle(int id);

	public void deleteArticle(int id);

	public void modifyArticle(int id, String title, String body);

	public int getLastInsertId();

	@Select("""
			<script>
			SELECT COUNT(*) AS cnt
			FROM article AS A
			WHERE 1
			<if test="boardId != 0">
				AND A.boardId = #{boardId}
			</if>
			</script>
				""")
	public int getArticlesCount(int boardId);
}