<%@page import="com.education25.model.ServletContextModel.OnlineExamContextModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.exam</title>
<link href="../../../css/user-view-pages-css/common-view-pages-css/education-welcome.css" type="text/css" rel="stylesheet">
<link href="../../../css/user-view-pages-css/courses-view-pages-css/course-section.css" type="text/css" rel="stylesheet">
<link href="../../../css/user-view-pages-css/onlineExam-and-certificat-view-pages-css/online-exam.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include file="/viewPages/user-view-pages/comman-web-information/message-show.jsp"%>
	<% 
	String user_name=null,projectPath=null;
	int i=0;
    user_name=(String)session.getAttribute("user_name");
    List<OnlineExamContextModel> onlineExamContext=null;
    projectPath = request.getContextPath();
    %>
	<header>
		<jsp:include page="../common-view-pages/navigation-bar.jsp" /> 
		<nav class="second_nav only_online_exam_nav_bar">
			<p id="first_heading">WELCOME TO EDUCATION25</p>
			<p id="second_heading">After given exam get certificate</p>
		</nav>
	</header>
	<main id="main_online_examp">
	
<%
    try {%>
	    <div class="course_section">
		    <input type="hidden" id="projectPath" value="<%= projectPath %>">
		    <input type="hidden" id="userName" value="<%= user_name %>">
	    		<%onlineExamContext=(List<OnlineExamContextModel>)application.getAttribute("onlineExamContext");
	    		if(onlineExamContext!=null){
		        for(OnlineExamContextModel examContext:onlineExamContext){
		        		int paper_id = examContext.getPaper_id();
		            String paper_name = examContext.getPaper_Name();
		            int Total_ques=examContext.getTotal_ques();
			        	int option_ques=examContext.getOption_ques();
			        int notOption_ques=examContext.getNotOption_ques();
			        String image_link=examContext.getImage_link();
		        %>
					<div class="course_box course_box_color<%=(i % 3)%>">
						<div class="add_image_container">
							<button type="button" onclick="startExam('<%= paper_name %>')"
								id="subject_image_add_short_id_<%= paper_id %>"
								class="image_button_open_course">
		
								<% if (image_link != null && !image_link.isEmpty()) { %>
									<img src="<%= image_link != null ? image_link : "" %>" class="subcourse_image">
								<% } else { %>
								<div
									class="without_image_container without_image_container_color<%=(i % 3)%>">
									<p><%= paper_name %></p>
								</div>
								<% } %>
							</button>
						</div>
		
						<div class="subcourse_details">
							<span class="text_size"><b><%= paper_name %></b></span> <span
								id="text_deco1"> (total Q=<%= Total_ques %>)<br>
								<%= option_ques %> Q (given 4 options)<br> <%= notOption_ques %>
								Q (multiple option)
							</span> <br>
							<button class="exam_start" onclick="startExam('<%= paper_name %>', '<%= paper_id %>')">
								Exam Start</button>
						</div>
					</div>
				<% i++; }
		        }%>
			</div>

		<%  
	} catch ( Exception e) {
        e.printStackTrace();
    } 
%>
	</main>
	<footer id="footer">
		<jsp:include page="../common-view-pages/footer.jsp" />
	</footer> 
	<script src="../../../js/user-view-pages-js/onlineExam-and-certificat-view-pages-js/online-Exam-form.js"></script>
</body>
</html>