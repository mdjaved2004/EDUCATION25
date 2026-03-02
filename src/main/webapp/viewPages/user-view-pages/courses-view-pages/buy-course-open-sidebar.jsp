<%@page import="com.education25.model.userModel.coursesModel.SubCourseSubHeadingContentGetModel"%>
<%@page import="com.education25.model.userModel.coursesModel.SubCourseHeadingContentGetModel"%>
<%@page import="java.util.List"%>
<%
List<SubCourseHeadingContentGetModel> subCourseHeading =null;
List<SubCourseSubHeadingContentGetModel> subCourseSubHeading =null;

subCourseHeading = (List<SubCourseHeadingContentGetModel>)request.getAttribute("SubCourseHeading");
subCourseSubHeading = (List<SubCourseSubHeadingContentGetModel>)request.getAttribute("SubCourseSubHeading");
%>
<ul id="course_context_open_side_bar">
	
	<%if(subCourseHeading!=null && subCourseSubHeading!=null){
			for(SubCourseHeadingContentGetModel headingInfo : subCourseHeading){ %>
			<li>
				<p class="heading_side_bar"><%= headingInfo.getHeadingName() %></p>
				<ul>
					<%
					for(SubCourseSubHeadingContentGetModel subHeadingInfo : subCourseSubHeading) { 
						if(headingInfo.getHeadingId()==subHeadingInfo.getHeadingId()){
						%>
							<li class="Sub_heading_side_bar">
								<a href="#<%= subHeadingInfo.getSubHeadingName() %>"
									onclick="highlight_sidebar_link(this);"> <%= subHeadingInfo.getSubHeadingName() %>
								</a>
							</li>
						<% }
					}%>
				</ul>
			</li>
		<% } 
	}%>
</ul>

<script src="../../../js/user-view-pages-js/courses-view-pages-js/education25-course-open-sidebar.js" type="text/javascript"></script>