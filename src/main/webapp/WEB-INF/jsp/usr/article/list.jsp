<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 리스트</title>
</head>
<body>

		<h1>게시물 리스트</h1>
		<div style="border: 1px solid black; display: inline-block; width: 10%; text-align: center;">
				<a style="display: block;" href="../home/main">메인페이지로 이동</a>
		</div>
		<div style="border: 1px solid black; display: inline-block; width: 10%; text-align: center;">
				<a style="display: block;" href="/usr/article/write">글쓰기</a>
		</div>
		<hr />
		<table style="border-collaspe: collaspe; width: 700px; background-color: pink;" border=2px>
				<thead>
						<tr>
								<th>번호</th>
								<th>날짜</th>
								<th>제목</th>
								<th>작성자</th>
						</tr>
				</thead>
				<tbody>
						<c:forEach var="article" items="${articles }">
								<tr>
										<th>${article.id }</th>
										<th>${article.regDate.substring(0,10) }</th>
										<th>
												<a href="detail?id=${article.id }">${article.title }</a>
										</th>
										<th>${article.name }</th>
								</tr>
						</c:forEach>
				</tbody>
		</table>


</body>
</html>