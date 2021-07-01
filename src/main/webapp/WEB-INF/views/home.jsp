<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h2>시작ddddd</h2>
		</div>
		<c:if test="${!empty email }">
			<div>
				<h1>${member.email }${message }</h1>
			</div>
		</c:if>
		<div>
			<h2>
				<a href="survey">설문조사</a>
			</h2>
		
		<h2>
			<a href="memberList">회원목록</a>
		</h2>
		<h2>
			<a href="member/memberInsert">회원등록</a>
		</h2>
	</div>
	</div>
</body>
</html>