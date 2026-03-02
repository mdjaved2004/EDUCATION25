<%@page import="com.education25.model.userModel.coursesModel.SubCourseSubHeadingContentGetModel"%>
<%@page import="com.education25.model.userModel.coursesModel.SubCourseHeadingContentGetModel"%>
<%@page import="java.util.List"%>
<%
List<SubCourseSubHeadingContentGetModel> subCourseSubHeading1 =null;

subCourseSubHeading1 = (List<SubCourseSubHeadingContentGetModel>)request.getAttribute("SubCourseSubHeading");
%>

<% if(subCourseSubHeading1!=null){
	for(SubCourseSubHeadingContentGetModel subHeadingInfo1 : subCourseSubHeading1) {  %>
		<section id="<%= subHeadingInfo1.getSubHeadingName() %>">
			<div class="sub_heading_name_definition_div">
				<div class="sub_heading_name_div">
					<p class="sub_heading_name"><%= subHeadingInfo1.getSubHeadingName()%></p>
				</div>
				<div class="sub_heading_definition_div">
					<p class="sub_heading_definition"><%= subHeadingInfo1.getDefinition() %></p>
				</div>
			</div>
			<%if(subHeadingInfo1.getExample()!=null){%>
				<div class="sub_heading_example_div">
					<span>Example : <span class="copy-btn" onclick="copyText(this)">
						<span class="material-symbols-outlined"> content_copy</span>copy</span>
					</span>
					<p class="sub_heading_example"><%= subHeadingInfo1.getExample() %></p>
				</div>
			<%}%>
		</section>
	<%}
	}
%>