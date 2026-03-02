<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String projectPath= request.getContextPath();%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.login</title>
<link href="../../../css/user-view-pages-css/auth-view-pages-css/login-register.css" type="text/css" rel="stylesheet">
</head>
<body>

<!-- Static page include  -->
<%@ include 	file="../comman-web-information/message-show.jsp"%>

<div class="container">
    <h2>Login</h2>
    <form action="<%= request.getContextPath() %>/viewPages/user-view-pages/auth-view-pages/login" method="post">
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

    <p id="or">or</p>

    <div>
        <a href="forget-password.jsp" id="forget_password">Forget Password</a>
    </div>

    <a id="button_register" href="resister-page.jsp">Create account</a>
</div>

</body>
</html>
