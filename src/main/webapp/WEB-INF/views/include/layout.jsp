<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="/css/footer.css">
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
<script src="/bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="/css/navbar.css">

<meta charset="UTF-8">
<title><tiles:insertAttribute name="title"/></title>
</head>
<body>
    <tiles:insertAttribute name="navbar"/>
	<tiles:insertAttribute name="body"/>
	<tiles:insertAttribute name="footer"/>
</body>
</html>