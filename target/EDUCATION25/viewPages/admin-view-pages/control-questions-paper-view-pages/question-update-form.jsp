<%@page import="com.education25.model.ServletContextModel.OnlineExamContextModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25</title>
<link href="../../../css/admin-view-pages-css/auth-view-pages-css/login.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%@ include 	file="../common-view-pages/message-show.jsp"%>
	<%@ include 	file="../admin-other-information/redirect-login-page-if-not-login-email.jsp"%>
	<% 
		String projectPath=null, id=null;
		
		projectPath=request.getContextPath();
		id=(String) request.getAttribute("id");
	
		List<String> paperNameList=null;
		
		paperNameList=(List<String>)request.getAttribute("paperNameList"); 
	
	%>
	<div class="container">
		<form action="<%= projectPath %>/viewPages/admin-view-pages/control-questions-paper-view-pages/question-update-form-check?id=<%=id%>"
			method="post">
			<div class="form-group">
				<label for="paperName">Paper Name:</label> 
				<input type="text" list="paper-name" id="paperName" name="paper_name"
					placeholder="Enter capital letter and Number" maxlength="30"
					required>
				<datalist id="paper-name">					
					<% for(String paperName : paperNameList) {%>
    						<option value="<%= paperName %>">
					<%}%>				
				</datalist>
			</div>
			<button type="submit" class="submit-btn">Submit</button>
		</form>
	</div>
</body>
</html>