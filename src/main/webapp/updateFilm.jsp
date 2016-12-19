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
<form action="updateFilm" method="post">
	<table><input name="filmId" type="hidden" value="${film.filmId }">
		<tr>
			<td>title:</td><td><input name="title" type="text" value="${film.title }"></td>
		</tr>
		<tr>
			<td>description:</td><td><textarea name="description" rows="4">${film.description }</textarea></td>
		</tr>
		<tr>
			<td>language:</td><td><select name="language">
									<c:forEach var="item" items="${list }">
										<option value="${item.languageId }">${item.name }</option>
									</c:forEach>
								</select></td>
		</tr>
		<tr><td><input type="submit" value="修改"><input type="reset" value="重置"></td></tr>
	</table>
	${info }
</form>
</body>
</html>