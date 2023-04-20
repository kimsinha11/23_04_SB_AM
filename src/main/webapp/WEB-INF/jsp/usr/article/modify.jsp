<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.KoreaIT.ksh.demo.vo.Article"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<c:set var="pageTitle" value="ARTICLE MODIFY" />
<%@ include file="../common/head.jspf"%>
<%
Article article = (Article) request.getAttribute("article");
%>

<h1>${article.id }번 게시물 수정
</h1>


<form method="post" action="modify">
		<div>
				번호 :
				<input value="${article.id }" type="text" name="id" />
		</div>
		<div>
				수정날짜 :
				${article.updateDate }
		</div>
		<div>
				제목 :
				<input value="${article.title }" type="text" name="title" placeholder="제목을 입력해주세요" />
		</div>
		<div>
				내용 :
				<textarea type="text" name="body" placeholder="내용을 입력해주세요">${article.body }</textarea>
		</div>
		<a href="modify?id=${article.id }">수정</a>
		
</form>


