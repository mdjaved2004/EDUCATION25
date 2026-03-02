<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.question-paper-image-upload</title>
<link href="../../../css/admin-view-pages-css/control-courses-view-pages-css/admin-course-content-add-image.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%@ include file="question-paper-update-image-data.jsp" %>
	<%@ include 	file="../common-view-pages/message-show.jsp"%>
	
	<header id="header">
		<%@ include file="../common-view-pages/navigation-bar.jsp" %>
	</header>
	<main id="main_container">
		<section class="course_container">
			<form id="form" enctype="multipart/form-data">
				<div class="add_image_container">
					<input type="file" id="image_input" name="image_input" accept="image/*" required hidden>
					<label for="image_input" id="image_input_label">
					<img src="<%= image_link != null ? image_link : "" %>" id="profile_pic" <%if(image_link==null){%> class="profile_pic_class" <%} %>> 
						<%if(image_link==null){%>
							<span id="upload_text">Upload Image</span> 
						<% }%>
					</label>
				</div>

				<div class="course_box course_box_color<%=(paper_id % 3)%>">
					<p><%= paper_name %></p>
					<p>
						Total Question =
						<%= total_ques %></p>
				</div>
				<button type="button" onclick="addExtraInfoInForm(`<%= id %>`,`<%= paper_name %>`, `<%= paper_id %>`,  `<%= image_link %>`, `<%= projectPath %>`)" class="btn" >submit</button>
			</form>
		</section>
	</main>
	<footer id="footer">	
		<%@ include file="../common-view-pages/footer.jsp"%>
	</footer>
	<script src="../../../js/admin-view-pages-js/control-questions-paper-view-pages-js/question-paper-update-image.js" type="text/javascript"></script>

</body>
</html>