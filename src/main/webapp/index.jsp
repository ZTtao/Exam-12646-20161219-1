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
<div style="margin:15px;">
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header" style="width:80%;">
  		<c:choose>
  			<c:when test="${empty customer }">
  				<button onclick="window.location.href='login.jsp'" class="btn btn-default navbar-btn">登录</button>
  			</c:when>
  			<c:otherwise>
  			  	<button onclick="window.location.href='logout'" class="btn btn-default navbar-btn">退出登录</button>
  			</c:otherwise>
  		</c:choose>
  		<button onclick="window.location.href='showFilm'" class="btn btn-default navbar-btn">查看Film</button>
  		<button onclick="window.location.href='showAddFilm'" class="btn btn-default navbar-btn">添加Film</button>
      	<c:if test="${customer ne null }"><p class="navbar-text navbar-right">welcome,<span class="label" style="color:green;">${customer.firstName }</span></p></c:if>
    </div>
  </div>
</nav>
</div>
</body>
</html>