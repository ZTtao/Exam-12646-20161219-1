<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<button onclick="window.location.href='index.jsp'">主页</button>
	<table>
		<tr>
			<td>film_id</td><td>title</td><td>description</td><td>language</td>
		</tr>
		<c:forEach var="item" items="${list }">
			<tr>
				<td>${item.filmId }</td><td>${item.title }</td><td>${item.description}</td><td>${item.languageName}</td><td><button onclick="window.location='showUpdateFilm?id=${item.filmId}'">修改</button><button onclick=deleteFilm(${item.filmId})>删除</button></td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${pageNow ne 1 }" var="varname">
	<button onclick="window.location='showFilm?pageNow=${pageNow-1}'">上一页</button>
	</c:if>
	${pageNow }/${pageCount }
	<c:if test="${pageNow ne pageCount }"><button onclick="window.location='showFilm?pageNow=${pageNow+1}'">下一页</button></c:if>
	${info }
</body>
<script type="text/javascript">
	function deleteFilm(id){
		if(confirm("确定删除？id:"+id)){
			window.location="deleteFilm?id="+id;
		}
	}
</script>
</html>