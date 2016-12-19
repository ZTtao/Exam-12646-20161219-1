<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header" style="width:80%;">
      <button onclick="window.location.href='index.jsp'" class="btn btn-default navbar-btn">主页</button>
      <p class="navbar-text navbar-right">welcome,<span class="label" style="color:green;">${customer.firstName }</span></p>
    </div>
  </div>
</nav>
<div style="margin:100px;">
<form action="addFilm" method="post"  class="form-horizontal" role="form">
	<div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">Title</label>
    <div class="col-sm-10">
      <input name="title" type="text" class="form-control"  placeholder="title">
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">Description</label>
    <div class="col-sm-10">
      <textarea name="description" rows="4"  class="form-control"  placeholder="description" ></textarea>
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">Language</label>
    <div class="col-sm-10">
    	<select name="language">
			<c:forEach var="item" items="${list }">
			<option value="${item.languageId }">${item.name }</option>
			</c:forEach>
		</select>
    </div>
  </div>
  <div class="form-group">
  	<c:if test="${info ne null }">
  		<label class="col-sm-2 control-label"></label>
		<div class="col-sm-10">
      		<div class="alert alert-danger" role="alert" style="font-size:10px;height:46px;width:213px;">${info }</div>
    	</div>
	</c:if>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input type="submit" value="添加" class="btn btn-default"><input type="reset" value="重置" class="btn btn-default">
    </div>
  </div>
</form>
</div>
</body>
</html>