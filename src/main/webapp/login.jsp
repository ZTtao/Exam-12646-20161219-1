<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header" style="width:80%;">
      <button onclick="window.location.href='index.jsp'" class="btn btn-default navbar-btn">主页</button>
    </div>
  </div>
</nav>
<div style="margin:50px;">
	<form action="login" method="post">
		<dir class="form-group" style="width:20%;">
			<input name="firstName" type="text" class="form-control"  placeholder="first name">
			<c:if test="${info ne null }">
				<div class="alert alert-danger" role="alert" style="font-size:10px;height:46px;width:213px;">${info[0] }</div>
			</c:if>
			<br>
			<input type="submit" value="登录" class="btn btn-default">
		</dir>
	</form>
	</div>
</body>
</html>