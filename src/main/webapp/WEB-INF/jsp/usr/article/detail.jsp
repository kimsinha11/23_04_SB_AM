<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="pageTitle" value="DETAIL" />
<%@ include file="../common/head.jspf"%>

<%
boolean isLogined = (boolean) request.getAttribute("isLogined");
%>
<section class="mt-10 text-xl">
		<div class="mx-auto">
				<table class="table-box-type-1" style="border-collaspe: collaspe; width: 700px; background-color: lightblue;"
						border=2px>
						<thead>
								<tr>
										<th>번호</th>
										<th>${article.id }</th>
								</tr>
								<tr>
										<th>작성날짜</th>
										<th>${article.regDate.substring(0,10) }</th>
								</tr>
								<tr>
										<th>수정날짜</th>
										<th>${article.updateDate.substring(0,10) }</th>
								</tr>
								<tr>
										<th>작성자</th>
										<th>${article.name }</th>
								</tr>
								<tr>
										<th>제목</th>
										<th>${article.title }</th>
								</tr>
								<tr>
										<th>내용</th>
										<th>${article.body }</th>
								</tr>


						</thead>

				</table>

		</div>
		<div class="btns">
				<%
				if (!isLogined) {
				%>
				<button type="button" onclick="history.back()">뒤로가기</button>
				<%
				}
				%>
				<%
				if (isLogined) {
				%>
				<button type="button" onclick="history.back()">뒤로가기</button>
				<a href="modify?id=${article.id }">수정</a>
				<a onclick="if(confirm('정말 삭제하시겠습니까?') == false) return false;"href="delete?id=${article.id }">삭제</a>
				<%
				}
				%>
		</div>


</section>
