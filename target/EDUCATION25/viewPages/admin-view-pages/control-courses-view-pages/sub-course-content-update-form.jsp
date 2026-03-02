<%@page import="com.education25.model.ServletContextModel.CoursesInformationGetModel"%>
<%@page import="com.education25.model.adminModel.coursesControlModel.SubCoursesAndCourseContentModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Education25</title>
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
		String projectPath=null, id=null;
		
		projectPath=request.getContextPath();
		id=(String) request.getAttribute("id");
	
		List<SubCoursesAndCourseContentModel> subCoursesInfo=null;
		subCoursesInfo=(List<SubCoursesAndCourseContentModel>)request.getAttribute("SubCourseInfo"); 
	
		List<CoursesInformationGetModel> coursesInfo=null;
		coursesInfo =(List<CoursesInformationGetModel>)application.getAttribute("coursesList");

	%>
	<div class="container">
		<form action="<%= projectPath %>/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-view?id=<%=id%>" method="post">
			<div class="form-group">
				<label for="course-name">Course Name :</label>
				<select id="course-name" name="course_name"required">
					<option value="" disabled selected hidden>Choose a course</option>
					
					<%for(CoursesInformationGetModel courseName :coursesInfo) { %>
     					<option value="<%= courseName.getCourse_name() %>" course-id="<%= courseName.getCourse_id() %>">
							<%= courseName.getCourse_name() %>
						</option>
						<%}%>
				</select>
			</div>
			<div class="form-group">
				<label for="sub-course-name">Subject Name:</label>
				<input type="text" list="sub_course_name_list" id="sub-course-name" name="sub_course_name" 
					placeholder="enter or select subject name" maxlength="28" required>
				
				<datalist id="sub_course_name_list">
					<% for(SubCoursesAndCourseContentModel subCoursesModelInfo: subCoursesInfo){ %>
						<option value="<%= subCoursesModelInfo.getSubCourseName()%>"
							course_id_inSubCorse="<%= subCoursesModelInfo.getCourseId()%>" >
					<%}%>
					
				</datalist>
			</div>
			<button type="submit" class="submit-btn">Submit</button>
		</form>
	</div>
    <script 	src="../../../js/admin-view-pages-js/control-courses-view-pages-js/sub-course-content-update-form.js" type="text/javascript"></script>
 </body>
</html>