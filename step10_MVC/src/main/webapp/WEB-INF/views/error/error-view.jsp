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
<h3>
메시지 : ${errMsg } <br>
에러이름 : ${errClass }<br>
상태코드 : ${statusCode }
</h3>
<a href="${pageContext.request.contextPath }/ex03_exception.html">홈으로 이동</a>
</body>
</html>