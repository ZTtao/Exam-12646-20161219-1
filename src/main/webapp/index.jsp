<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
<div style="margin:100px;">
	<ul class="nav nav-pills">
  		<c:choose>
  			<c:when test="${empty customer }">
  				<li id="login"><a href="login.jsp">登录</a></li>
  			</c:when>
  			<c:otherwise>
  			  	<li id="logout"><a href="logout">退出登录</a></li>
  			</c:otherwise>
  		</c:choose>
  		<li id="showFilm"><a href="showFilm">查看Film</a></li>
  		<li id="addFilm"><a href="showAddFilm">添加Film</a></li>
	</ul>
	</div>
</body>
</html>