<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table class="table table-sm">
	  <thead class="table-dark">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	  </thead>
	  
		<c:forEach var="n" items="${list }">
			<tr>
				<td>${n.num}</td>
				<td><a href="board_detail?num=${n.num}" style="text-decoration: none;">${n.title} <c:if test="${!(n.cmt_count == 0)}"><span style="color: red;">[${n.cmt_count}]</span></c:if></a></td>
				<td>${n.writer_id}</td>
				<td>${n.regdate}</td>
				<td>${n.hit}</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>