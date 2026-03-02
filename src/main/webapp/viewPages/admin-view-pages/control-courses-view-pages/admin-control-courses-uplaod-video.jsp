<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.sql.*"%>
<%@page import="com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.courses-update</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="../../../css/admin-view-pages-css/control-courses-view-pages-css/admin-courses-upload-video.css" type="text/css"	rel="stylesheet">
<script src="../../../js/admin-view-pages-js/control-courses-view-pages-js/admin-course-contxt-video.js" type="text/javascript"></script>
</head>
<body>
	<% String message=null,message_error=null,course_name=null,sub_course_name=null,sub_course_short_id=null, image_link=null;	
	if (session.getAttribute("message")!= null) {
		message=(String)session.getAttribute("message");
		session.removeAttribute("message");
	}else if(session.getAttribute("message_error")!=null){
		message_error=(String)session.getAttribute("message_error");
		session.removeAttribute("message_error");
	}
	course_name=(String)session.getAttribute("course_name");
	sub_course_name=(String)session.getAttribute("sub_course_name");
	sub_course_short_id=String.valueOf(session.getAttribute("sub_course_short_id"));
	image_link=(String)session.getAttribute("image_link");
	
	course_name =new ReplaceSpaceTo_().replaceSpaceTo_(course_name);
	sub_course_name =new ReplaceSpaceTo_().replaceSpaceTo_(sub_course_name);
	
	/* login resister usern information  */
	 String user_name=null,admin_email=null,admin_position=null;
     	user_name=(String)session.getAttribute("user_name");
     /* admin information */
     	admin_email=(String)session.getAttribute("admin_email");
     	admin_position=(String)session.getAttribute("admin_position");
   %>
	<header>
		<jsp:include page="../../user-view-pages/common-view-pages/navigation-bar.jsp" />
		<nav id="subject_bar">
			<a id="menu_icon_link"> <span class="material-symbols-outlined"
				id="course_context_open_menu">menu</span>
			</a>
		</nav>
		<ul id="course_context_open_side_bar">
		</ul>

	</header>
	<main id="main">
		<!-- `lecture_id`, `title`, `description`, `upload_date`, `lecture_video`, `format`, `thumbnail`, `instructor_id`, `views`, `likes`, `dislikes`, `show_vi_li_dli` -->
		<%try (Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/education25course_"+course_name+"", "root", "Mdjaved2004")){
		String video_info_query="select lecture_id, title, description, upload_date, instructor_id, views, likes, dislikes, show_vi_li_dli from " + sub_course_name  +"_lectures_"+sub_course_short_id+"";
		PreparedStatement ps = com.prepareStatement(video_info_query);	
		ResultSet rs = ps.executeQuery();
		String description=null;
		int  lecture_id=0;
		%>
		<section>
			<%if (message != null) {%>
			<p class="message"><%=message%></p>
			<%}else if(message_error!= null){ %>
			<p class="message_error"><%=message_error%></p>
			<%} 
		while (rs.next()) { 
			String lectureId=rs.getString("lecture_id");
			%>
			<div class="course_container" id="Lecture_<%=lectureId %>" style="border-radius:10px 10px 7px 7px;">
				<div class="image_container" >
					<%if(image_link!=null){%>
					<img src="images/course_context_image/<%=image_link%>"
						class="thumbnail">
					<%}else{%>
					<div class="thumbnail"></div>
					<%} %>
					<span class="material-symbols-outlined three_dot">more_vert</span>
					<span class="date"><%=rs.getString("upload_date") %></span>
					<div id="lecture<%= lectureId %>" class="play_video"
						onclick="playVideo(this, '<%= lectureId %>')">
						<span id="lecture<%= lectureId %>"
							class="material-symbols-outlined"> play_circle </span>
					</div>
				</div>
				<div class="title_box">
					<textarea name="title" class="title" required><%=rs.getString("title") %></textarea>
				</div>
				<%-- <div class="views_like_dislike">
		        	<span >
				        <span class="material-symbols-outlined">thumb_up</span>
				        <span><%=rs.getString("likes") %></span>
			        </span>
			        <span>
				        <span class="material-symbols-outlined">thumb_down</span>
				        <span><%=rs.getString("dislikes") %></span>
				     </span>
			        <span class="views">views <%=rs.getString("views") %></span>	       	       
		        </div> --%>
				<div class="description_box" style="border-radius:0 0 7px 7px;">
					<textarea name="description" style="border-radius:0 0 7px 7px;" class="description" readonly><%=rs.getString("description") %></textarea>
				</div>
			</div> 
			<script>
	      addListItem('<%= lectureId %>');
           </script>
			<%  } %>
			<div id="add_video">Upload lecture(video)</div>
			<form action="<%= request.getContextPath() %>/admin_upload_video" method="post"
				enctype="multipart/form-data">
				<div id="upload_video_container">
					<div id="video_container">
						<input type="file" id="video_input" name="video_input"
							accept="video/*" required hidden> <label
							for="video_input" id="video_input_label">Upload Video</label>
						<video id="video" controls
							style="display: none; width: 100%; height: 100%;"></video>
					</div>
					<div id="title">
						<textarea name="title" class="title" placeholder="Enter title"
							required></textarea>
					</div>
					<div id="description_container">
						<textarea name="description" class="description"
							placeholder="Enter description" required></textarea>
					</div>
					<input type="hidden" name="course_name" value="<%= course_name%>">
					<input type="hidden" name="sub_course_name"
						value="<%= sub_course_name%>"> <input type="hidden"
						name="sub_course_short_id" value="<%= sub_course_short_id%>">
				</div>
				<br>
				<button type="submit" class="btn">Submit</button>
			</form>
		</section>
		<% } catch (SQLException e) {
	    e.printStackTrace(); 
	} %>
	</main>
	<footer id="footer">
		<jsp:include page="../../user-view-pages/common-view-pages/footer.jsp" />
	</footer>

	<script>
		let video_input = document.getElementById("video_input");
		let video = document.getElementById("video");
		let upload_text = document.getElementById("upload_text");
		let video_input_label = document.getElementById("video_input_label");
		
		video_input.onchange = function () {
		    let file = video_input.files[0];
		
		    if (file) {
		        if (file.size > 550 * 1024 * 1024) { // 550MB 
		            alert("File size must be less than 60MB");
		            video_input.value = "";
		            return;
		        }
		        video_input_label.style.display = "none";
		        video.src = URL.createObjectURL(file);
		        video.style.display = "block";
		        upload_text.style.display = "none";
		        
		    }
		};
	</script>
	<script src="../../../js/user-view-pages-js/courses-view-pages-js/education25-course-info-open-sidebar.js" type="text/javascript"></script>
</body>
</html>