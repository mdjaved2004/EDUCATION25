<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.question-paper</title>
<link href="../../../css/user-view-pages-css/auth-view-pages-css/login-register.css" type="text/css" rel="stylesheet">

</head>
<body>
	<%
	String message_error=null;	
	if (session.getAttribute("message_error")!= null) {
		message_error=(String)session.getAttribute("message_error");
		session.removeAttribute("message_error");
	}
	%>
	<% try {
		Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/education25questionbanck", "root",
				"Mdjaved2004");
		Statement stmt=com.createStatement();
		ResultSet rs=stmt.executeQuery("select * from paper_name_all");
	    %>
	<div class="container">
		<form action="<%= request.getContextPath() %>/delete_question_paper" method="post">
			<% if(message_error != null){ %>
			<p id="message_error"><%= message_error %></p>
			<%} %>
			<div class="form-group">
				<label for="paperName">Paper Name which deleted:</label> <input
					type="text" list="paper-name" id="paperName" name="paper_name"
					placeholder="Enter capital letter and Number" maxlength="30"
					required>
				<datalist id="paper-name">
					<% while(rs.next()){ %>
					<option value="<%= rs.getString("paper_Name") %>">
						<%}%>
					
				</datalist>
			</div>
			<button type="submit" class="submit-btn">Submit</button>
		</form>
	</div>
	<% }catch (SQLException e) {
			e.printStackTrace();
			}%>


</body>
</html>