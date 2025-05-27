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
<h3>가입된 정보</h3>
아이디 : ${dto.id } <br>
이름 : ${dto.name } <br>
나이 : ${dto.age } <br>
주소 : ${dto.addr } <br>
<hr>
메시지 : ${msg } <br>
메뉴 : ${menu }

</body>
</html>