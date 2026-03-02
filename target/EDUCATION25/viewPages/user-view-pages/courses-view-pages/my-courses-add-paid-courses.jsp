<%{ String projectPath=request.getContextPath(); %>	 
<%@page import="java.util.List"%>
<%@page import="com.education25.model.userModel.coursesModel.MyCoursesPaidSubCoursesModel"%>

<%
	String sub_cour_name=null, learning_days=null, sort_id=null, image_link=null, course_name=null;
	int sub_course_id=0, course_id=0, price=0, i=0;
	List<MyCoursesPaidSubCoursesModel> paidCourseList =null;
	try {
		paidCourseList = (List<MyCoursesPaidSubCoursesModel>) request.getAttribute("myCoursesPaid");
		if (paidCourseList != null && !paidCourseList.isEmpty()) {
			%>
			<div id="my_ourses">My courses(Paid)</div>
			<%
			for(MyCoursesPaidSubCoursesModel myCoursePaid : paidCourseList){
				sub_course_id = myCoursePaid.getSub_course_Id();
				sub_cour_name = myCoursePaid.getSub_cour_name();
				learning_days = myCoursePaid.getLearning_days();
				price= myCoursePaid.getPrice();		
				sort_id = myCoursePaid.getSort_id();
				image_link = myCoursePaid.getImage_link();
				
				course_id = myCoursePaid.getCourse_id();
				course_name = myCoursePaid.getCourse_name();
		    %>
		    
				<div class="course_box course_box_color<%=(i%3)%>">
					<div class="add_image_container">
						<button type="button" id="subject_image_add_short_id_<%= sort_id %>"	class="image_button_open_course"
							onclick="buyCourseOpen('<%= sort_id %>','<%= projectPath %>')">
							
							<%if(image_link !=null){%>
								<img src="<%= image_link != null ? image_link : "" %>" class="subcourse_image">
							<%} else{ %>
								<p class="without_image_container without_image_container_color<%=(i%3)%>"><%= sub_cour_name %></p>
							<%}%>
						</button>
					</div>
					<div class="subcourse_details">
						<p class="sub_course_heading"><%= sub_cour_name %></p>
						<p>learning Days(<%= learning_days %> days)</p>
						<p>Price - &#8377;<%= price %></p>
						<button type="button" id="subject_open_short_id_<%= sort_id %>" class="course_button course_button_buy"
							onclick="buyCourseOpen('<%= sort_id %>','<%= projectPath %>')">
							open</button>
					</div>
				</div>
				<%i++;
				}
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
}%>