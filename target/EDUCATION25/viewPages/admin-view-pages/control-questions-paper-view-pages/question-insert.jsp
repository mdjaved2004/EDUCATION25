<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.question-paper-insert</title>
<link href="../../../css/admin-view-pages-css/admin-home-page.css" type="text/css" rel="stylesheet">
<link href="../../../css/admin-view-pages-css/courses-and-question-paper-css/admin-question-insersts.css" type="text/css"	rel="stylesheet">
</head>
<body>
	<%@ include 	file="../common-view-pages/message-show.jsp"%>
	<% String text_show=null; 
		text_show = (String) request.getAttribute("text_show");
	%>
	<header id="header">
		<%@ include file="../common-view-pages/navigation-bar.jsp" %>
	</header>
	<main id="main">
		<section class="section">
		<% if (text_show == null) { %>
		    <jsp:include page="/viewPages/admin-view-pages/control-questions-paper-view-pages/question-insert-inputs.jsp" />
		<% } else { %>
		    <jsp:include page="/viewPages/admin-view-pages/control-questions-paper-view-pages/question-insert-input-with-data-show.jsp" />
		<% } %>
		</section>		
	</main>
	
	
	<script 	src="<%=projectPath%>/js/admin-view-pages-js/common-view-pages/admin-home-page.js"></script>
	
</body>
</html>