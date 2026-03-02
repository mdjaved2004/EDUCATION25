<%@page import="com.education25.model.ServletContextModel.CoursesInformationGetModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EDUCATION25</title>
<link href="../../../css/admin-view-pages-css/auth-view-pages-css/login.css" type="text/css" rel="stylesheet">
<style>
#course-name, #learning_days, #price, #sub-course-name {
	width: 100%;
	height: 2rem;
	font-size: 16px;
	border: 1px solid black;
	border-radius: 5px;
}
</style>
</head>
<body>
	<%@ include 	file="../common-view-pages/message-show.jsp"%>
	<%@ include 	file="../admin-other-information/redirect-login-page-if-not-login-email.jsp"%>
	<%
		List<CoursesInformationGetModel> coursesInfo=null;
		try {
			coursesInfo =(List<CoursesInformationGetModel>)application.getAttribute("coursesList"); 
	%>
			<div class="container">
				<form action="<%=request.getContextPath() %>/viewPages/admin-view-pages/control-courses-view-pages/sub-course-add-new-form" method="post">

					<div class="form-group">
						<label for="course-name">Course Name :</label>
						<%--  <input type="text" id="sub-course-name" name="course_name" placeholder="enter course name or choose option (first choose)  required> --%>
						<select id="course-name" name="course_name" required>
							<option value="" disabled selected hidden>Choose a course</option>
							<% for(CoursesInformationGetModel course : coursesInfo) { %>
								<option value="<%= course.getCourse_name() %>">
									<%= course.getCourse_name() %>
								</option>
							<%}%>
						</select>
					</div>
					<div class="form-group">
						<label for="sub-course-name">Subject Name:</label> <input
							type="text" id="sub-course-name" name="sub_course_name"
							pattern="[A-Za-z0-9 ]+"
							title="Only letters (A-Z, a-z) and numbers (0-9) allowed."
							placeholder="enter subject name" maxlength="30" required>
					</div>
					<div class="form-group">
						<label for="learning_days">Learning Days:</label> <input
							type="number" id="learning_days" name="learning_days"
							placeholder="enter learning days" required>
					</div>
					<div class="form-group">
						<label for="price">Price:</label> <input type="number" id="price"
							name="price" placeholder="Enter course price" min="0" step="1"
							required pattern="[0-9]+"
							title="Only  numbers (0-9) allowed, decimals not allowed">	
					</div>
					<button type="submit" class="submit-btn">Submit</button>
				</form>
			</div>
	<% }catch (Exception e) {
			e.printStackTrace();
	}%>
</body>
</html>