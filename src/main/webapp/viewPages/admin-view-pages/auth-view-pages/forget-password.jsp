<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.forget-password</title>
<link href="../../../css/admin-view-pages-css/auth-view-pages-css/login.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include 	file="../common-view-pages/message-show.jsp"%>
	<div class="container">
		<h2>Forget Fassword</h2>
		<form action="<%= request.getContextPath() %>/viewPages/admin-view-pages/auth-view-pages/forget-password" method="post">
			<div class="form-group">
				<label for="email"><b>Email</b></label> <input type="email"
					id="email" name="email" placeholder="Enter email (maxlength 35)"
					maxlength="35" required>
			</div>
			<button type="submit">Next</button>
		</form>
	</div>
</body>
</html>