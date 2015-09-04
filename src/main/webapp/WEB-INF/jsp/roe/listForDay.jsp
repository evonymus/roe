<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>List</title>
</head>
<body>
<h2> items</h2>
	<ul>
		<c:forEach var="roe" items="${list }">
			<li><c:out value="${roe.code }"/></li>
		</c:forEach>
	</ul>
</body>
</html>