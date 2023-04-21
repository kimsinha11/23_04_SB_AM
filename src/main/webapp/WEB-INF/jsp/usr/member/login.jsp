<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:set var="pageTitle" value="LOGIN" />
<%@ include file="../common/head.jspf"%>


<h1 style="text-align: center; padding: 70px 20px 0;">로그인</h1>


<form method="post" action="doLogin">

	<div>
		아이디 : <textarea type="text" placeholder="아이디를 입력해주세요" name="loginId" /></textarea>
	</div>
	<div>
		비밀번호 : <textarea type="text" placeholder="비밀번호를 입력해주세요" name="loginPw" /></textarea>
	</div>


	<button type="submit"> 로그인</button>

</form>