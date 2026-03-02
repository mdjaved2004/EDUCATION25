<%String projectPath= request.getContextPath();%>
<%@page import="com.education25.model.ServletContextModel.CoursesInformationGetModel"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>


<link href="<%=projectPath%>/css/user-view-pages-css/common-view-pages-css/nav-bar-course-show.css" type="text/css" rel="stylesheet">
<%
	List<CoursesInformationGetModel> coursesInfo=null;
	try {
		coursesInfo =(List<CoursesInformationGetModel>)application.getAttribute("coursesList"); %>
	
	
	<nav id="subject_bar">
		<%
		if(coursesInfo!=null){
			for(CoursesInformationGetModel course : coursesInfo) { 
				if(course.getNoOfSubCourses()>0){ %>
				  <button class="subject_bar_itom"  id="openMainCourse_<%=course.getCourse_id()%>"
			                onclick="openMainCourse('<%=course.getCourse_name()%>', '<%=course.getCourse_id()%>','<%=projectPath%>')">
			            <%=course.getCourse_name()%>
			        </button>
			   <% }
			   } 
		}%>
	</nav>
		   <%
	} catch(Exception e) {
	    e.printStackTrace();
	}
	%>
	<script src="<%=projectPath%>/js/user-view-pages-js/courses-view-pages-js/course-open-form-main.js"></script>