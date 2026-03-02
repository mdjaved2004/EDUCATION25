<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.profile</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="<%= request.getContextPath() %>/css/user-view-pages-css/auth-view-pages-css/profile.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%@ include file="../comman-web-information/user-not-login-redirect-login-page.jsp"%>
	<%@ include file="../comman-web-information/message-show.jsp"%>
	<%@ include file="../comman-web-information/user-full-information.jsp"%>

	<header>
		<jsp:include page="../common-view-pages/navigation-bar.jsp" /> 
	</header>
	<main>
		<div class="container">
			<div id="profile_picture_box_change">
				<span class="material-symbols-outlined" id="default_pic_cange">person</span>
			</div>
			<form action="<%= request.getContextPath() %>/viewPages/user-view-pages/user-information-view-pages/profileChange" method="post">
				<div class="form-group">
					<label for="full_name"><b>Full Name</b></label>
					<input type="text" id="full_name" name="full_name" value="<%=user_name%>" placeholder="<%=user_name%>"
						maxlength="35">
				</div>
				<div class="form-group">
					<label for="email"><b>Email</b></label> <input type="email"
						id="email" name="email" placeholder="<%=user_email%>" maxlength="35"
						readonly="readonly">
				</div>
				<div class="form-group">
					<label for="username"><b>UserName</b></label> <input type="text"
						id="username" name="username" value="<%=user_user_name%>" placeholder="<%=user_user_name%>"
						maxlength="30">
				</div>
				<button type="submit">Update</button>
			</form>
		</div>
	</main>
	<footer id="footer">
		<jsp:include page="../common-view-pages/footer.jsp" />
	</footer>

</body>
</html>