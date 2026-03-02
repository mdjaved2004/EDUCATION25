<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>com.education25.my-courses</title>
	<link href="../../../css/user-view-pages-css/common-view-pages-css/education-welcome.css" type="text/css" rel="stylesheet">
	<link href="../../../css/user-view-pages-css/courses-view-pages-css/course-section.css" type="text/css" rel="stylesheet">
	<link href="../../../css/user-view-pages-css/onlineExam-and-certificat-view-pages-css/online-exam.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include file="../comman-web-information/message-show.jsp"%>
<%@ include file="../comman-web-information/user-not-login-redirect-login-page.jsp"%>
	<header>
		<jsp:include page="../common-view-pages/navigation-bar.jsp" /> 
		<nav class="second_nav" id="second_nav_id">
			<p id="first_heading">WELCOME TO EDUCATION25</p>
			<p id="second_heading">You can check all added course.</p>
		</nav>
	</header>

	<main id="main">	
		<section>
			<%@ include file="my-courses-add-paid-courses.jsp"%>
		</section>
		<section>
			<%@ include file="my-courses-add-free-courses.jsp"%>
		</section>
		<section>
			<%@ include file="my-courses-buy-courses-suggestion.jsp"%>
		</section>
	</main>
	<footer id="footer">
		<jsp:include page="../common-view-pages/footer.jsp" />
	</footer>

	<script src="../../../js/user-view-pages-js/courses-view-pages-js/course-open-form-create.js" type="text/javascript"></script>		
</body>
</html>