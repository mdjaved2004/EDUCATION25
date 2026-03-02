<%@page import="com.education25.model.adminModel.coursesControlModel.SubCourseSubHeadingModel"%>
<%@page import="com.education25.model.adminModel.coursesControlModel.SubCourseHeadingModel"%>
<%@page import="java.util.List"%>
<%
	String course_name = null, sub_course_name = null, course_id=null, sub_course_short_id=null;
	String projectPath1 =request.getContextPath();
	int i=0;
	List<SubCourseHeadingModel> subCourseHeading =null;
	List<SubCourseSubHeadingModel> subCourseSubHeading=null;
	
	course_name=(String)request.getAttribute("course_name");
	course_id=(String)request.getAttribute("course_id");
	sub_course_name=(String)request.getAttribute("sub_course_name");
	sub_course_short_id=(String)request.getAttribute("sub_course_short_id");
	
	subCourseHeading=(List<SubCourseHeadingModel>)request.getAttribute("SubCourseHeading");
	subCourseSubHeading=(List<SubCourseSubHeadingModel>)request.getAttribute("SubCourseSubHeading");
		
%>

<div class="course-info">
    <p>Course Name : <span><%= course_name %></span></p>
    <p>Subject Name : <span><%= sub_course_name %></span></p>
</div>
<%  int heading_id=0;
	for(SubCourseHeadingModel subCourseHeadingModel : subCourseHeading){
		heading_id = subCourseHeadingModel.getHeadingId();
		String heading_name = subCourseHeadingModel.getHeadingName(); %>

		<div class="heading-container">
			<label for="heading_id_<%= heading_id %>" class="heading_level">Heading
				<%= heading_id %></label>
			<textarea id="heading_id_<%= heading_id %>"
				name="heading_text_<%= heading_id %>" class="heading_text" rows="2"
				required><%= heading_name %></textarea>
		</div>

		<%	i=1;
		int sub_heading_id =0;
		for(SubCourseSubHeadingModel subCourseSubHeadingModel : subCourseSubHeading){
			int heading_id_in_sub_heading=subCourseSubHeadingModel.getHeadingId();
			
			if(heading_id_in_sub_heading==heading_id){ 
				String sub_heading_name = null, definition = null, example=null;
				
				sub_heading_id = subCourseSubHeadingModel.getSubHeadingId();
				sub_heading_name = subCourseSubHeadingModel.getSubHeadingName();
				definition = subCourseSubHeadingModel.getDefinition();
				example = subCourseSubHeadingModel.getExample();
			%>
				<div class="sub-heading">
					<label for="sub_heading_id_<%= sub_heading_id %>"
						class="heading_level">Sub Heading <%= i %></label>
					<textarea id="sub_heading_id_<%= sub_heading_id %>"
						name="sub_heading_text_<%= sub_heading_id %>"
						class="sub-heading-text" rows="2" required><%= sub_heading_name %></textarea>
				</div>
				<div class="sub-heading-defination">
					<label for="sub_heading_definition_id_<%= sub_heading_id %>"
						class="defination">Definition <%= i %></label>
					<textarea id="sub_heading_definition_id_<%= sub_heading_id %>"
						name="sub_heading_definition_<%= sub_heading_id %>"
						class="sub-heading-defination-text" required><%= definition %></textarea>
				</div>
				<div class="sub-heading-example">
					<label for="sub_heading_example_id_<%= sub_heading_id %>"
						class="example">Example <%= i %></label>
					<textarea id="sub_heading_example_id_<%= sub_heading_id %>"
						name="sub_heading_example_<%= sub_heading_id %>"
						class="sub-heading-example-text" required><%= example %></textarea>
				</div>		
			<%}
			  i++;	
			}
		}
		%>
		<center>	
			<button type="submit" id="delete_button"  onclick="delete_subject('<%= projectPath1 %>', '<%= sub_course_name %>', '<%= sub_course_short_id %>', '<%= course_name %>', '<%= course_id %>')">
				delete subject</button>
		</center>
<script 	src="../../../js/admin-view-pages-js/control-courses-view-pages-js/sub-course-deleted.js" 	type="text/javascript"></script>
