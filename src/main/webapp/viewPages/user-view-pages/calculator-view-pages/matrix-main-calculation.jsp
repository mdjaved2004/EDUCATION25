<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String projectPath1= request.getContextPath();%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.calculator-matrix</title>
<link href="../../../css/user-view-pages-css/calculator-view-pages-css/matrix-main-calculation.css" type="text/css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
	html, body {
		touch-action: none;
	}
</style>
</head>
<body>
<%{	String r_operator1=null;
		r_operator1=(String)request.getAttribute("r_operator");
	%>
	<!-- after solve matrix  data find  start -->
	<header>
		<jsp:include page="calculator-list-sidebar.jsp" /> 
	</header>
	
	<main id="main_container_matrix">
		<section id="Matrix_datails">
			<%@ include 	file="matrix-main-calculation-input-matrix-show.jsp"%>

			<%@ include 	file="matrix-main-calculation-result-show.jsp"%>				
		</section>
	</main>
	<footer id="footer">
		<jsp:include page="../common-view-pages/footer.jsp" />
	</footer>
	<script src="../../../js/user-view-pages-js/calculator-view-pages-js/matrix-main-calculation-matrix-solve-form.js"></script>
	
</body>
</html>
<%}%>