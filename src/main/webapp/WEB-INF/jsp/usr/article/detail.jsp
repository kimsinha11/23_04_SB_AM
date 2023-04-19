<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var = "pageTitle" value = "DETAIL"/>
<%@ include file="../common/head.jspf" %>

		<table style="border-collaspe: collaspe; width:700px; background-color: lightblue;" border = 2px>
				<thead>
						<tr>
								<th>번호</th>
								<th>날짜</th>
								<th>제목</th>
								<th>내용</th>
								<th>작성자</th>
						</tr>
				</thead>
				<tbody>
				
						<tr>
								<th>${article.id }</th>
								<th>${article.regDate.substring(0,10) }</th>
								<th>${article.title }</th>
								<th>${article.body }</th>
								<th>${article.name }</th>
						</tr>
						
				</tbody>
		</table>


</body>
</html>