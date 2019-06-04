<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberInfo List</title>
</head>
 
<body>
	<table border="2">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>이메일</th>
			<th>성별</th>
			<th>생년월일</th>
			<th>집 코드</th>
			<th>주소1</th>
			<th>주소2</th>
			<th>가입일</th>
			<th>가입시간</th>
			<th>수정일</th>
			<th>수정시간</th>
			<th>사진</th>
			<th>닉네임</th>
			<th>기타</th>
		</tr>
		<tr>
			<th>${list.miNum}</th>
			<th>${list.miName}</th>
			<th>${list.miId}</th>
			<th>${list.miEmail}</th>
			<th>${list.miTrans}</th>
			<th>${list.miBirth}</th>
			<th>${list.miZipcode}</th>
			<th>${list.miAddr1}</th>
			<th>${list.miAddr2}</th>
			<th>${list.miCredat}</th>
			<th>${list.miCretim}</th>
			<th>${list.miModdat}</th>
			<th>${list.miModtim}</th>
			<th><img src="${list.miMainImg}" width="50" height="50"></th>
			<th>${list.miNick}</th>
			<th>${list.miEtc}</th>
		</tr>
	</table>
</body>
</html>