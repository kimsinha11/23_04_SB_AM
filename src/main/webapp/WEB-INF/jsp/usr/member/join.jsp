<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:set var="pageTitle" value="JOIN" />
<%@ include file="../common/head.jspf"%>


<h1 style="text-align: center; padding: 70px 20px 0;">회원가입</h1>


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
	<div>
		이름 : <input style=" border: 1px solid black;" value="" type="text" name="title"
			placeholder="이름을 입력해주세요" />
	</div>
	<div>
		닉네임 : <input style=" border: 1px solid black;" value="" type="text" name="title"
			placeholder="닉네임을 입력해주세요" />
	</div>
	<div>
		전화번호 : <input style=" border: 1px solid black;" value="" type="text" name="title"
			placeholder="전화번호를 입력해주세요" />
	</div>
	<div>
		이메일 : <input style=" border: 1px solid black;" value="" type="text" name="title"
			placeholder="이메일을 입력해주세요" />
	</div>

<br />
	<button type="submit"> 회원가입</button>
</div>
</form>