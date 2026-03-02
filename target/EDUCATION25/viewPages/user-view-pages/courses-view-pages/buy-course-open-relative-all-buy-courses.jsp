<%@page import="com.education25.model.userModel.coursesModel.SubCourseRelativeCourseInformationGetModel"%>
<%@page import="java.util.List"%>
<%
   String projectPath1 = request.getContextPath();
	List<SubCourseRelativeCourseInformationGetModel> subCourseRelative =null;
	String course_name=null, course_id=null, sub_course_name=null, sub_course_sort_id=null;
	
	course_name =(String) request.getAttribute("course_name");
	course_id =(String) request.getAttribute("course_id");
	sub_course_name =(String) request.getAttribute("sub_course_name");
	sub_course_sort_id =(String) request.getAttribute("sub_course_sort_id");
	subCourseRelative=(List<SubCourseRelativeCourseInformationGetModel>)request.getAttribute("SubCourseRelative"); 
%>
		<nav id="subject_bar">
			<a id="menu_icon_link"> <span class="material-symbols-outlined"
				id="course_context_open_menu">menu</span>
			</a>
			<%if(subCourseRelative!=null){
					for(SubCourseRelativeCourseInformationGetModel subCourseRelativeFreeSubCourse: subCourseRelative){
						String rel_sub_course_name = subCourseRelativeFreeSubCourse.getSub_course_name();
						String rel_sub_course_sort_id = subCourseRelativeFreeSubCourse.getSub_course_sort_id();
					%>
						<button type="button"
							id="subject_open_short_id_<%= rel_sub_course_sort_id %>"
							class="subject_bar_itom <%if(rel_sub_course_name.equals(sub_course_name)){%> subject_bar_itom_clickeble<%}%>"
							onclick="buyCourseOpen('<%= rel_sub_course_sort_id %>','<%= projectPath1 %>')">
							<%= rel_sub_course_name %>
						</button>
					<% } 
				}%>
		</nav>
<script src="../../../js/user-view-pages-js/courses-view-pages-js/buy-course-open-form-create.js" type="text/javascript"></script>