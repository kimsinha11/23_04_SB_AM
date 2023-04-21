<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:set var="pageTitle" value="LOGIN" />
<%@ include file="../common/head.jspf"%>


<h1 style="text-align: center; padding: 70px 20px 0;">로그인</h1>


<form style="text-align: center;" method="post" action="doJoin">
<div  style="display: inline-block; text-align:left;">

	<div>
		아이디 :<input style=" border: 1px solid black;" value="" type="text" name="title"
			placeholder="아이디를 입력해주세요" />
	</div>
	<div>
		비밀번호 : <input style=" border: 1px solid black;" value="" type="text" name="title"
			placeholder="비밀번호를 입력해주세요" />
	</div>

<br />
	<button style="display: inline; background-color: lightgray" type="submit"> 로그인</button>
	<a style="display: inline; padding: 2px; background-color: lightgray" href="/usr/member/join">회원가입</a>
</div>
</form>