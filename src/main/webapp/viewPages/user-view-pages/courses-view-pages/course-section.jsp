<%@page import="com.education25.model.ServletContextModel.SubCourseInformationModel"%>
<%@page import="com.education25.model.ServletContextModel.CoursesInformationGetModel"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<% String ProjectPath1 = request.getContextPath(); %>

<link href="<%=ProjectPath1%>/css/user-view-pages-css/courses-view-pages-css/course-section.css" type="text/css" rel="stylesheet">	
<% 
	String course_name=null, sub_course_Name=null, image_link=null;
	int i=0, course_id=0, sub_course_id=0, price=0, sort_id=0;
%>	
<%@ include file="../comman-web-information/user-user-name-get.jsp" %>
<%
Map<CoursesInformationGetModel, List<SubCourseInformationModel>> courseAndsubSourseInfo = null;

try {
    courseAndsubSourseInfo =(Map<CoursesInformationGetModel, List<SubCourseInformationModel>>)application.getAttribute("coursesAndSubCoursesMap");
    if(courseAndsubSourseInfo!=null){
	    for (Map.Entry<CoursesInformationGetModel, List<SubCourseInformationModel>> entry : courseAndsubSourseInfo.entrySet()) {
	        CoursesInformationGetModel courseInfo = entry.getKey();
	        List<SubCourseInformationModel> SubCourseInfo = entry.getValue();
	        course_id = courseInfo.getCourse_id();
	        course_name = courseInfo.getCourse_name();
	        	i = 0;
			%>
			<section>
			    <div class="course_heading"><%= course_name %></div>
			    <div class="course_section">
			        <div class="course_container">
			            <%
			            for (SubCourseInformationModel subCourse : SubCourseInfo) {
			                sub_course_Name = subCourse.getSub_course_name();
			                sub_course_id =subCourse.getSub_course_id();
			                price = subCourse.getPrice();
			                sort_id = subCourse.getSort_id();
			                image_link = subCourse.getImage_link();
			            %>
			            <div class="course_box course_box_color<%=(i%3)%>">
			                <div class="add_image_container">
			                    <button type="button" id="subject_image_add_short_id_<%= sort_id %>" class="image_button_open_course"
			                    <% if (price == 0) { %>
			                        onclick="freeCourseOpen('<%= course_name %>', '<%= course_id %>', '<%= sub_course_Name %>', '<%= sort_id %>','<%= price %>','<%= ProjectPath1 %>')"
			                    <% } else {
			                          if (user_user_name != null) { %>
				                            onclick="BuyCourseDetails('<%= sort_id %>', '<%= ProjectPath1 %>')"
				                    <%  } else { %>
				                            onclick="location.href='<%= request.getContextPath() %>/viewPages/user-view-pages/auth-view-pages/login-page.jsp'"
				                    <%  }
			                    } %>>
		                        <% if (image_link != null) { %>
									<img src="<%= image_link != null ? image_link : "" %>" class="subcourse_image">
		                        <% } else { %>
		                            <p class="without_image_container without_image_container_color<%=(i%3)%>"><%= sub_course_Name %></p>
		                        <% } %>
			                    </button>
			                </div>
			                <div class="subcourse_details">
			                    <p class="sub_course_heading"><%= sub_course_Name %></p>
			                    <p>learning Days(<%= subCourse.getLearning_days() %> days)</p>
			                    <p>Price - &#8377;<%= price %>.00</p>
			                    <% if (price == 0) { %>
			                        <button type="button" id="subject_add_short_id_<%= sort_id %>" class="course_button"
			                            onclick="freeCourseAdd('<%= course_name %>', '<%= course_id %>', '<%= sub_course_Name %>', '<%= sort_id %>','<%= price %>','<%= ProjectPath1 %>')">
			                            Add Course
			                        </button>
			                    <% } %>
			                    <button type="button" id="subject_open_short_id_<%= sort_id %>" class="course_button"
				                    <% if (price == 0) { %>
				                        onclick="freeCourseOpen('<%= course_name %>', '<%= course_id %>', '<%= sub_course_Name %>', '<%= sort_id %>','<%= price %>','<%= ProjectPath1 %>')"
				                    <% } else {
				                        if (user_user_name != null) { %>
				                            onclick="BuyCourseDetails('<%= sort_id %>', '<%= ProjectPath1 %>')"
				                    <%  } else { %>
				                            onclick="location.href='<%= request.getContextPath() %>/viewPages/user-view-pages/auth-view-pages/login-page.jsp'"
				                    <%  }
				                    } %>>
			                        <% if (price == 0) { %> open <% } else { %> Buy course <% } %>
			                    </button>
			                </div>
			            </div>
			            <% i++; } %>
			        </div>
			        <br><br>
			    </div>
			</section>
	<%
		}
    }
} catch (Exception e) {
    e.printStackTrace();
}
%>	
<script src="<%=ProjectPath1%>/js/user-view-pages-js/courses-view-pages-js/course-open-form-create.js" type="text/javascript"></script>