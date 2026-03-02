<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>com.education.open</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
	<link href="../../../css/user-view-pages-css/courses-view-pages-css/buy-course-open.css" type="text/css"	rel="stylesheet">
</head>
<body>
	<%@ include 	file="../comman-web-information/message-show.jsp"%>
	 <header id="header">  	
	 	<%@ include file="../common-view-pages/navigation-bar.jsp" %>
	 	<%@ include file="buy-course-open-relative-all-buy-courses.jsp" %>
	</header>
	<main id="main">
		<%@ include file="buy-course-open-sidebar.jsp" %>
		<%@ include file="buy-course-open-content-data.jsp" %>
	</main>

<script src="../../../js/user-view-pages-js/courses-view-pages-js/buy-course-open.js" type="text/javascript"></script>
</body>
</html>