<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EDUCATION25</title>

<link href="../../../css/admin-view-pages-css/admin-home-page.css" type="text/css" rel="stylesheet">
<link href="../../../css/admin-view-pages-css/control-courses-view-pages-css/admin.css" type="text/css" rel="stylesheet">
</head>

<body>
<%
    String projectPath1 = request.getContextPath();
%>

<%@ include file="../common-view-pages/message-show.jsp"%>

<header id="header">
    <%@ include file="../common-view-pages/navigation-bar.jsp" %>
</header>

<main id="main">
	<section>
		<div class="admin_list">
	        <span class="span">Create question paper : </span>
	        <a href="question-paper-templet.jsp" class="btn-link btn">
	            Create Paper
	        </a>
	    </div>
	
	    <div class="admin_list">
	        <span class="span">Update question paper : </span>
	        <a href="<%=projectPath1 %>/viewPages/admin-view-pages/control-questions-paper-view-pages/question-update-form?id=update" class="btn-link btn">
	           Update Paper
	        </a>
	    </div>
	
	    <div class="admin_list">
	        <span class="span">Add or update image in paper : </span>
	        <a href="<%=projectPath1 %>/viewPages/admin-view-pages/control-questions-paper-view-pages/question-update-form?id=updateImage" class="btn-link btn">
	           update image
	        </a>
	    </div>
	
	    <div class="admin_list">
	        <span class="span">Delete question paper : </span>
	        <a href="<%=projectPath1 %>/viewPages/admin-view-pages/control-questions-paper-view-pages/question-update-form?id=deletePaper" class="btn-link btn_denger">
	           Delete Paper
	        </a>
	    </div>
	</section>
</main>

<footer id="footer">
    <jsp:include page="../../user-view-pages/common-view-pages/footer.jsp" />
</footer>

<script src="<%=projectPath1%>/js/admin-view-pages-js/common-view-pages/admin-home-page.js"></script>

</body>
</html>