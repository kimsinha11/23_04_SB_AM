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

		<hr />
		<table border="3">
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
								<td>${article.id }</td>
								<td>${article.regDate.substring(0,10) }</td>
								<td><a href="getArticle?id=${article.id }">${article.title }</a></td>
								<td>${article.name }</td>
						</tr>
						</c:forEach>
				</tbody>
		</table>


</body>
</html>