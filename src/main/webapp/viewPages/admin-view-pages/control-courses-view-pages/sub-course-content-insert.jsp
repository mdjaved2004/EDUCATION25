<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25</title>
<link href="../../../css/admin-view-pages-css/admin-home-page.css" type="text/css" rel="stylesheet">
<link href="../../../css/admin-view-pages-css/control-courses-view-pages-css/admin-insert-course.css" type="text/css"
	rel="stylesheet">
</head>
<body>
<%@ include 	file="../common-view-pages/message-show.jsp"%>
	<header id="header">
		<%@ include file="../common-view-pages/navigation-bar.jsp" %>
	</header>
	<main id="main">
		<p id="note">Note:- If the header box below is not needed then
			leave it blank.</p>
		<form action="<%= request.getContextPath() %>/viewPages/admin-view-pages/control-courses-view-pages/sub-cources_insert_data" method="post">
			<%@ include 	file="sub-course-content-insert-default-input-value-set.jsp"%>
			
			<!-- admin_cources_insert_data -->
			<div id="heading" ></div>
			
			<div id="add-heading-and-submit-div">
				<button type="submit" id="submit_botton" class="add_button">Submit</button>
				<button id="addHeadingButton" type="button">Add Heading</button>
			</div>
		</form>
	</main>
<script src="../../../js/admin-view-pages-js/control-courses-view-pages-js/admint-course-contex-insert.js" type="text/javascript"></script>
<script 	src="../../../js/admin-view-pages-js/common-view-pages/admin-home-page.js"></script>
</body>
</html>
