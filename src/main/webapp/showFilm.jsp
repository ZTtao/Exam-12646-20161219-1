<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<c:choose>
	<c:when test="${info eq '删除成功' }">
		<div class="alert alert-success alert-dismissible" role="alert" style="width:90%;margin:0 auto;">
  			<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
  			<strong>Warning!</strong> ${info }
		</div>
	</c:when>
	<c:when test="${info eq '存在外键约束，无法删除' }">
		<div class="alert alert-warning alert-dismissible" role="alert" style="width:90%;margin:0 auto;">
  			<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
  			<strong>Warning!</strong> ${info }
		</div>
	</c:when>
</c:choose>
<div class="table-responsive" style="width:90%;margin:0 auto;">
	<table class="table">
		<tr>
			<td>film_id</td><td>title</td><td>description</td><td>language</td>
		</tr>
		<c:forEach var="item" items="${list }">
			<tr>
				<td>${item.filmId }</td><td>${item.title }</td><td>${item.description}</td><td>${item.languageName}</td><td><button onclick="window.location='showUpdateFilm?id=${item.filmId}'" class="btn btn-default">修改</button><button onclick=deleteFilm(${item.filmId}) class="btn btn-default">删除</button></td>
			</tr>
		</c:forEach>
	</table>
	
	<nav>
  <ul class="pager">
  	<c:if test="${pageNow ne 1 }" var="varname">
    	<li><a href="showFilm?pageNow=${pageNow-1}">Previous</a></li>
    </c:if>
	${pageNow }/${pageCount }
    <c:if test="${pageNow ne pageCount }">
    	<li><a href="showFilm?pageNow=${pageNow+1}">Next</a></li>
    </c:if>
  </ul>
</nav>
</div>
</body>
<script type="text/javascript">
	function deleteFilm(id){
		if(confirm("确定删除？id:"+id)){
			window.location="deleteFilm?id="+id;
		}
	}
</script>
</html>