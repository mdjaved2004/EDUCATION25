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

<%  int head_id_tepm=1, heading_id=0;
	for(SubCourseHeadingModel subCourseHeadingModel : subCourseHeading){
		heading_id = subCourseHeadingModel.getHeadingId();
		String heading_name = subCourseHeadingModel.getHeadingName(); %>

		<div class="heading-container">
			<form action="<%= request.getContextPath() %>/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update" method="post" style="display:inline;">
				<label for="heading_id_<%= heading_id %>" class="heading_level">Heading <%= heading_id %></label>
				<textarea id="heading_id_<%= heading_id %>" 	name="heading_text_<%= heading_id %>" class="heading_text" rows="2" maxlength="100" required><%= heading_name %></textarea>			
				<input type="hidden" name="form_id" value="heading" />
				<input type="hidden" name="heading_id" value="<%= heading_id %>" />
				<input type="hidden" name="course_name" 	value="<%= course_name %>" />
				<input type="hidden" name="course_id" value="<%= course_id %>" /> 
				<input type="hidden" name="sub_course_name" value="<%= sub_course_name %>" />
				<input type="hidden" name="sub_course_short_id" value="<%= sub_course_short_id %>" />
				<span class="heading_update_add">
					<button type="submit">Update</button>
				</span>
			</form>
			<span class="heading_update_add">
			<button type="button" id="add_button_heading<%= heading_id %>" class="create-heading-btn"
				onclick="createHeading(this, '<%= projectPath1 %>', '<%= heading_id %>', '<%= course_name %>','<%= course_id %>','<%= sub_course_name %>','<%= sub_course_short_id %>')">
				Add heading</button>
				
			<button type="button" id="add_button_sub_heading<%= heading_id %>" class="create-heading-btn"
				onclick="create_sub_heading_using_heading(this, '<%= projectPath1 %>', '<%= heading_id %>', '<%= head_id_tepm %>','<%= course_name %>','<%= course_id %>','<%= sub_course_name %>','<%= sub_course_short_id %>')">
				Add sub-heading</button>
				
			<button type="button" id="add_button_heading0<%= heading_id %>"
				class="remove-btn"
				onclick="removeHeading('<%= heading_id %>', '<%= projectPath1 %>', '<%= course_name %>','<%= course_id %>','<%= sub_course_name %>','<%= sub_course_short_id %>')">
				remove</button>

		</span>
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
				<form action="<%= request.getContextPath() %>/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update" method="post">
					<div class="sub-heading">
						<label for="sub_heading_id_<%= sub_heading_id %>" class="heading_level">Sub Heading <%= i %></label>
						<textarea id="sub_heading_id_<%= sub_heading_id %>" name="sub_heading_text_<%= sub_heading_id %>" maxlength="100"
							class="sub-heading-text" rows="2" required><%= sub_heading_name %></textarea>
						
						<input type="hidden" name="form_id" value="sub-heading" />
						<input type="hidden" name="course_name" value="<%= course_name %>" />
						<input type="hidden" name="course_id" value="<%= course_id %>" />
						<input type="hidden" name="sub_course_name" value="<%= sub_course_name%>" />
						<input type="hidden" name="sub_course_short_id" value="<%= sub_course_short_id %>" />
						<input type="hidden" name="sub_heading_id" value="<%= sub_heading_id %>" />
						<input type="hidden" name="heading_id" value="<%= heading_id %>" />
						
						<span class="sub_heading_update_add">
							<button type="submit">Update</button>
							<%if(i!=1){ %>
								<button type="button" id="add_button_sub_heading<%= heading_id %>" class="create-heading-btn"
									onclick="create_sub_heading(this, '<%= projectPath1 %>', '<%= heading_id %>', '<%= sub_heading_id %>', '<%= i %>', '<%= course_name %>','<%= course_id %>','<%= sub_course_name %>','<%= sub_course_short_id %>' )">Add
									sub-heading</button> <%}%>
									
								<button type="button" id="add_button_heading0<%= heading_id %>" class="remove-btn"
									onclick="remove_sub_heading('<%= heading_id %>', '<%= projectPath1 %>', '<%= sub_heading_id %>', '<%= course_name %>','<%= course_id %>','<%= sub_course_name %>','<%= sub_course_short_id %>')">
									remove</button>
						</span>
					</div>
					
					<div class="sub-heading-defination">
						<label for="sub_heading_definition_id_<%= sub_heading_id %>" 	class="defination">Definition <%= i %></label>
						<textarea id="sub_heading_definition_id_<%= sub_heading_id %>" name="sub_heading_definition_<%= sub_heading_id %>"
							maxlength="4000" class="sub-heading-defination-text" required><%= definition %></textarea>
					</div>
					
					<div class="sub-heading-example">
						<label for="sub_heading_example_id_<%= sub_heading_id %>" class="example">Example <%= i %></label>
						<textarea id="sub_heading_example_id_<%= sub_heading_id %>" name="sub_heading_example_<%= sub_heading_id %>" maxlength="4000"
							class="sub-heading-example-text"><%= example %></textarea>
					</div>
				</form>	
	
			
			<%		
			  i++; head_id_tepm++;	
			}
		}
			if(sub_heading_id>0){
				sub_heading_id=sub_heading_id+1;%>
				<div class="sub-heading">
					<span class="last_option_button"><%if(i!=1){ %>
						<button type="button" id="add_button_sub_heading<%= heading_id %>" class="create-heading-btn"
						onclick="create_sub_heading(this, '<%= projectPath1 %>', '<%= heading_id %>', '<%= sub_heading_id %>', '<%= i %>', '<%= course_name %>','<%= course_id %>','<%= sub_course_name %>','<%= sub_course_short_id %>' )">
						Add sub-heading</button> <%}%>
					</span>
				</div>			
				<%
			} %>
			
			
			
			<%		
	}
if(heading_id>0){
	heading_id=heading_id+1;%>
	<div class="heading-container">
		<span class="last_option_button heading-container_last">
			<button type="button" id="add_button_heading<%= heading_id %>" class="create-heading-btn"
				onclick="createHeading(this, '<%= projectPath1 %>',  '<%= heading_id %>', '<%= course_name %>','<%= course_id %>','<%= sub_course_name %>','<%= sub_course_short_id %>')">
				Add heading</button>
		</span>
	</div>	
	<%
}%>
<script 	src="../../../js/admin-view-pages-js/control-courses-view-pages-js/admin-course-context-update-add-heading-or-sub-heading.js" 	type="text/javascript"></script>