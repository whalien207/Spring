<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>목록화면</h3>
	<c:forEach var="article" items="${list }" varStatus="num">
		${num.index}
		${article.name } 의 국어점수 = ${article.kor } , 영어점수 = ${article.eng }
		<!-- 원래 삭제는 post방식이어야 한다. 복잡해서 지금은 get방식으로 진행 -->
		<a href="delete?num=${article.num}">삭제</a> 
		<br/>
	</c:forEach>

</body>
</html>