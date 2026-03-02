<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.question-paper-update-question</title>
<link href="../../../css/admin-view-pages-css/admin-home-page.css" type="text/css" rel="stylesheet">
<link href="../../../css/admin-view-pages-css/courses-and-question-paper-css/admin-question-insersts.css" type="text/css"
	rel="stylesheet">
</head>
<body>
<%@ include 	file="../common-view-pages/message-show.jsp"%>

	<header id="header">
		<%@ include file="../common-view-pages/navigation-bar.jsp" %>
	</header>
	<main id="main" class="main_container">
		<%@ include file="question-paper-update-question-data.jsp" %>
	</main>
		
	<script 	src="<%=projectPath%>/js/admin-view-pages-js/common-view-pages/admin-home-page.js"></script>
</body>
</html>