<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String projectPath=request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.register</title>
<link href="../../../css/user-view-pages-css/auth-view-pages-css/login-register.css" type="text/css" rel="stylesheet">
</head>
<body>

<%@ include 	file="../comman-web-information/message-show.jsp"%>

	<div class="container">
		<h2>Register</h2>
		<form action="<%= request.getContextPath() %>/viewPages/user-view-pages/auth-view-pages/resister" method="post">
			<div class="form-group">
				<label for="full_name"><b>Full Name</b></label> <input type="text"
					id="full_name" name="fullName"
					placeholder="Enter full name  (maxlength 35)"
					pattern="[A-Za-z ]{4,35}"
					title="Name must be 4-35 characters long and contain only letters and numbers."
					maxlength="35" autofocus required>
			</div>
			<div class="form-group">
				<label for="email"><b>Email</b></label> <input type="email"
					id="email" name="email" placeholder="Enter email (maxlength 35)" 	maxlength="35"
					title="Please enter a valid email address (e.g., name@example.com)."
					required>
			</div>
			<div class="form-group">
				<label for="username"><b>UserName</b></label> <input type="text"
					id="username" name="username" placeholder="Create username "
					pattern="[A-Za-z0-9]{4,15}"
					title="Username must be 4-15 characters long and contain only letters and numbers."
					maxlength="15" required>
			</div>
			<label for="password"><b>Password</b></label>
			<div class="form-group password_icon">
				<input type="password" id="password" name="password"
					placeholder="Create password" pattern="[A-Za-z0-9]{4,15}"
					title="Password must be 4-15 characters long and contain only letters and numbers."
					maxlength="15" required>
			</div>
			<label for="confirm-password"><b>Confirm Password</b></label>
			<div class="form-group password_icon">
				<input type="password" id="confirm-password" name="confirmPassword"
					placeholder="conform password" pattern="[A-Za-z0-9]{4,15}"
					title="Confirm password must be 4-15 characters long and contain only letters and numbers."
					maxlength="15" required>
			</div>
			<button type="submit">Register</button>
		</form>
		<p id="or">or</p>
		<a id="button_login" href="<%= projectPath %>/viewPages/user-view-pages/auth-view-pages/login-page.jsp">Login</a>
	</div>
</body>
</html>