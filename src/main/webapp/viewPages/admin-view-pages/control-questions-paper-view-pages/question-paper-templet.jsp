<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.question-paper-templet</title>
<link href="../../../css/user-view-pages-css/auth-view-pages-css/login-register.css" type="text/css" rel="stylesheet">
</head>
<body>
	<% String projectPath = request.getContextPath();%>
	<%@ include 	file="../common-view-pages/message-show.jsp"%>
	<%@ include 	file="../admin-other-information/redirect-login-page-if-not-login-email.jsp"%>
	<%@ include 	file="question-paper-templet-java-code.jsp"%>
	
	<div class="container1">
		<form action="<%= projectPath %>/viewPages/admin-view-pages/control-questions-paper-view-pages/ques_paper_templet_check" method="post">
			<div class="form-group">
				<label for="paper-name">Paper Name:</label> 
				<input type="text" id="paper-name" name="paper_name" placeholder="Enter paper name" 
					value="<%= paper_name != null ? paper_name : "" %>"
					pattern="[A-Za-z][A-Za-z0-9 ]*" title="First character must be a letter. Remaining characters can be letters, numbers, and spaces."
					maxlength="30"
					 required>
			</div>
			<div class="form-group">
				<label for="total-questions">Total Questions:</label> 
				<input type="number" id="total-questions" name="total_ques" max="40"
					value="<%= total_ques != null ? total_ques : "" %>" required>
			</div>
			<p class="form_text">Fill number of question and marks which	given options</p>
			<br>
			<div class="form-group">
				<label for="select_op_que">Number of question:</label>
				 <input 	type="number" id="select_op_que" name="select_op_ques"
				 	value="<%= select_que != null ? select_que : "" %>" required>
			</div>
			<div class="form-group">
				<label for="selected_marks">Every question marks:</label> 
				<input type="number" id="selected_marks" name="select_op_ques_marks"
					value="<%= select_marks != null ? select_marks : "" %>" max="10" placeholder="Enter less than 11" required>
			</div>
			<p class="form_text">Fill number of question and marks which not given options</p>
			<br>
			<div class="form-group">
				<label for="not_selected_op_que">Number of question:</label>
				 <input type="number" id="not_selected_op_que" name="not_select_op_ques"
					value="<%= notSelect_que != null ? notSelect_que : "" %>" required>
			</div>
			<div class="form-group">
				<label for="not_select_marks"> Every question marks:</label>
				 <input 	type="number" id="not_select_marks" name="not_select_op_ques_marks"
					value="<%= notSelect_marks != null ? notSelect_marks : "" %>" max="10" placeholder="enter less then 11" required>
			</div>
			<div class="form-group">
				<label for="Total_marks">Total marks:</label> 
				<input type="number" id="Total_marks" value="<%= total_marks != null ? total_marks : "" %>" name="total_marks" required>
			</div>
			<button type="submit" class="submit-btn">Submit</button>
		</form>
	</div>
</body>
</html>