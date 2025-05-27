<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>a.do요청결과</h1>
<h3>
메시지 : ${message }<br>
취미 :
<c:forEach items="${hobbies }" var="hobby">
	<input type="checkbox" name="hobby">${hobby}
</c:forEach>
</h3>

</body>
</html>