<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
	
<body>
	<form action="/mem/login" method="post">
		<h1>Do Login</h1>
		ID : <input type="text" id="miId" name="miId"/><br>
		PWD : <input type="password" id="miPwd" name="miPwd"/><br>
		<button>Login</button><br>	
	</form>	
	<button onclick="ggg()">회원가입</button>
<script>
 function ggg() {
	location.href="/member/signup.jsp";
}

</script>	
</body>
</html>