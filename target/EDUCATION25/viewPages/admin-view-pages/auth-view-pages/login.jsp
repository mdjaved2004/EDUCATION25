<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String projectPath= request.getContextPath();%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.login</title>
<link href="../../../css/admin-view-pages-css/auth-view-pages-css/login.css" type="text/css" rel="stylesheet">
</head>
<body>

<!-- Static page include  -->
<%@ include 	file="../common-view-pages/message-show.jsp"%>
	<div class="container">
	    <h2>Login</h2>
	    <form action="<%= request.getContextPath() %>/viewPages/admin-view-pages/auth-view-pages/login" method="post">
	        <div class="form-group">
				<label for="email"><b>Email</b></label> 
				<input type="email" 	id="email" name="email" placeholder="Enter email (maxlength 35)" 	maxlength="35"
					title="Please enter a valid email address (e.g., name@example.com)."
					required>
			</div>
	   
	        <div class="form-group">
	            <label for="username"><b>UserName</b></label>
	            <input type="text" id="username" name="username" placeholder="Enter username"
	                pattern="[A-Za-z0-9]{4,15}"
	                title="Username must be 4-15 characters long and contain only letters and numbers."
	                maxlength="15" autofocus required />
	        </div>
	        
	        <div class="form-group">
	            <label for="password"><b>Password</b></label>
	            <input type="password" id="password" name="password" placeholder="Enter password"
	                pattern="[A-Za-z0-9]{4,15}"
	                title="Password must be 4-15 characters long and contain only letters and numbers."
	                maxlength="15" required />
	        </div>			
	        <button type="submit">Login</button>
	    </form>
	    <div>
	    		<br>
	        <a href="forget-password.jsp" id="forget_password">Forget Password</a>
	    </div>	    
	</div>	
</body>
</html>