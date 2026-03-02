<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>com.education25</title>
	<!-- getContextPath given corrent project path which server run project -->
	<link href="<%=request.getContextPath()%>/css/user-view-pages-css/style.css" type="text/css" rel="stylesheet">
</head>
<body> 
<%@ include file="/viewPages/user-view-pages/comman-web-information/message-show.jsp"%>

	 <header id="header">  	
		<!--this page show navigation bar -->
		<jsp:include page="/viewPages/user-view-pages/common-view-pages/navigation-bar.jsp" /> 
		   
		<!--this page show second navigation bar after upper navigation bar -->
	 	<jsp:include page="/viewPages/user-view-pages/common-view-pages/nav-bar-course-show.jsp" /> 
	</header>
	
	<main id="main">			
		<!-- This section for show menu items OR features Icon in projects  -->
		<section>		
			<jsp:include page="/viewPages/user-view-pages/common-view-pages/component-show-section.jsp" /> 
		</section>
		
		<!-- This section show courses free or paid mixed -->
		<section>		
			<jsp:include page="/viewPages/user-view-pages/courses-view-pages/course-section.jsp" />
		</section>
	</main>	
	
	<footer id="footer">	
		<!-- Add footer in index page -->
		<jsp:include page="/viewPages/user-view-pages/common-view-pages/footer.jsp" />
	</footer>
	
	
</body>
</html>