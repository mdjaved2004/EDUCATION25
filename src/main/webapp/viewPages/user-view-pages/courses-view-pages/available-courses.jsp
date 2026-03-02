<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.available-courses</title>
<link href="../../../css/user-view-pages-css/style.css" type="text/css" rel="stylesheet">
<link href="../../../css/user-view-pages-css/common-view-pages-css/education-welcome.css" type="text/css" rel="stylesheet">
<style>
.second_nav {
	margin-top: 73px;
}
#main {
	position: relative;
	top:30px;
}
</style>
</head>
<body>
	<%@ include file="../comman-web-information/user-user-name-get.jsp" %>

	<header>
		<jsp:include page="../common-view-pages/navigation-bar.jsp" />
		<nav class="second_nav">
			
			<%if(user_user_name==null){%>
				<p id="login_message">you are not login,login first.</p>
			<% }%>
			<p id="first_heading">WELCOME TO EDUCATION25</p>
			<p id="second_heading">You can view all courses.</p>
		</nav>
	</header>
	<main id="main">
		<section>
			<jsp:include page="course-section.jsp" />
		</section>
	</main>
	<footer id="footer">
		<jsp:include page="../common-view-pages/footer.jsp" />
	</footer>
</body>
</html>