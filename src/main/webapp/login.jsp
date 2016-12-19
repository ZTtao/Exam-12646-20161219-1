<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div style="margin:100px;">
	<button onclick="window.location.href='index.jsp'">主页</button>
	<form action="login" method="post">
		<dir class="form-group" style="width:20%;">
			<input name="firstName" type="text" class="form-control"  placeholder="first name"><br>
			<input type="submit" value="登录" class="btn btn-default">
		</dir>
	</form>
	${info }
	</div>
</body>
</html>