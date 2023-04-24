<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="pageTitle" value="${board.code} " />
<%@ include file="../common/head.jspf"%>

<section class="mt-10 text-xs">
		<div class="mx-auto overflow-x-auto w-full">
				<table class="table-box-type-1 table w-full"
						style="border-collaspe: collaspe; width: 700px; background-color: pink;" border=2px>
						<thead>
							
								<tr>
								
										<th><label>
												<input type="checkbox" class="checkbox" />
										</label> </th>
										<th style="font-size:19px">번호</th>
										<th style="font-size:19px">날짜</th>
										<th style="font-size:19px">제목</th>
										<th style="font-size:19px">작성자</th>
								</tr>
						</thead>
						<tbody>
								<c:forEach var="article" items="${articles }">
										<tr>
											<th>
										<label>
												<input type="checkbox" class="checkbox" />
										</label>
								</th>
												<th>
														<div class="badge badge-lg">${article.id }</div>
												</th>
												<th>${article.regDate.substring(0,10) }</th>
												<th class="title">
														<a href="detail?id=${article.id }">${article.title }</a>
												</th>
												<th>${article.name }</th>
										</tr>
								</c:forEach>
						</tbody>
				</table>
				<style>
.title:hover {
	background-color: gray;
	color: pink;
}
</style>
		</div>
</section>

