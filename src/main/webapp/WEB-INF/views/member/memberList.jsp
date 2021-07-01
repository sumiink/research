<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>멤버목록 보기</title>
<script type="text/javascript">

	function fileDown(path, file){
		console.log(file);
		frm.filePath.value = path;
		frm.fileName.value = file;
		frm.submit();
		
	}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>회원목록</h1>
		</div>
		<div>
		<form id="frm" name="frm" action="fileDown.do" method="post">
			<table border="1">
				<tr>
					<th width="150">이메일</th>
					<th width="100">이름</th>
					<th width="150">사진</th>
					<th width="100">등록상태</th>
					<c:forEach var="member" items="${members }">
						<tr onmouseover="this.style.background ='blue'"
						onmouseout="this.style.background ='white'">
							<td>${member.email }</td>
							<td>${member.name }</td>
							<td>${member.fileName}</td>
							<td align="center">
							<c:if test="${!empty member.fileUuid }">
								<img width="30" src="resources/img/file.png" onclick="fileDown('${member.fileUuid}','${member.fileName }')">
							</c:if>
							</td>
						</tr>
					</c:forEach>
				</tr>
			</table>
		<input type="hidden" id="filePath" name="filePath">
		<input type="hidden" id="fileName" name="fileName"> 
		</form>
		</div>
	</div>
</body>
</html>