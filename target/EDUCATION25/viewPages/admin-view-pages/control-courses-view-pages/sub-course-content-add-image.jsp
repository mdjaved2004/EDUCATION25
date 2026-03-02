<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.control-courses</title>
<link href="../../../css/admin-view-pages-css/control-courses-view-pages-css/admin-course-content-add-image.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%@ include file="sub-course-content-add-image-data.jsp" %>
	<%@ include 	file="../common-view-pages/message-show.jsp"%>
	
	<header id="header">
		<%@ include file="../common-view-pages/navigation-bar.jsp" %>
	</header>
	<main id="main_container">
		<section class="course_container">
			<div class="course_heading"><%= course_name %></div>
			<form  id ="form" enctype="multipart/form-data">
				<div class="add_image_container">
					<input type="file" id="image_input" name="image_input" accept="image/*" required hidden>
					<label for="image_input" id="image_input_label"> 
						<img src="<%= image_link != null ? image_link : "" %>" id="profile_pic" <%if(image_link==null){%> class="profile_pic_class" <%} %>>
						 <%if(image_link==null){%>
						 	<span id="upload_text">Upload Image</span>
						 <% }%>
					</label>
				</div>

				<div class="course_box course_box_color<%= (random > 0) ? (random % 3) : 0 %>">
					<p class="p"><%= sub_course_name %></p>
					<p class="p">
						learning Days (<%= learning_days %>
						days)
					</p>
					<p class="p">Click (check for detail)</p>
					<p class="p">
						Price - &#8377;<%= price %></p>

				</div>
				<button type="button" onclick="addExtraInfoInForm(`<%= id %>`,`<%= course_name %>`, `<%= course_id %>`, `<%= sub_course_name %>`, `<%= sub_course_short_id %>`, `<%= learning_days %>`, `<%= price %>`, `<%= image_link %>`, `<%= projectPath %>`)" class="btn">submit</button>
			</form>
		</section>
	</main>
	<footer id="footer">	
		<%@ include file="../common-view-pages/footer.jsp"%>
	</footer>

<script src="../../../js/admin-view-pages-js/control-courses-view-pages-js/sub-course-content-add-image.js" type="text/javascript"></script>

</body>
</html>