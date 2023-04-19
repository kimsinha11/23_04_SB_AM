<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>

		<h1>글쓰기</h1>

		<hr />

		<form method="post" action="doWrite">
				<div>
						제목 :
						<input type="text" placeholder="제목을 입력해주세요" name="title" />
				</div>
				<div>
						내용 :
						<textarea type="text" placeholder="내용을 입력해주세요" name="body" /></textarea>
						<!--<textarea name="" id="" cols="30" rows="10"></textarea>*/-->
				</div>
				<button type="submit">글쓰기</button>
		</form>
		</table>


</body>
</html>