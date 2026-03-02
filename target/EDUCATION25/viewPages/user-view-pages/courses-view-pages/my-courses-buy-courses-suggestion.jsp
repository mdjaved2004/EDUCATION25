<%{ String projectPath=request.getContextPath(); %>	
				
<%@page import="com.education25.model.userModel.coursesModel.MyCoursesFreeSubCoursesModel"%>
<%@page import="java.util.List"%>

<div id="my_ourses">Buy courses</div>				
<%
	String sub_cour_name=null, learning_days=null, sort_id=null, image_link=null, course_name=null;				
	int sub_course_id=0, course_id=0, price=0, i=0;
	List<MyCoursesFreeSubCoursesModel> buyCoursesSuggestion=null;
	
	try { 
		buyCoursesSuggestion=(List<MyCoursesFreeSubCoursesModel>) request.getAttribute("myCoursesBuySuggestion");
		
		if (buyCoursesSuggestion != null && !buyCoursesSuggestion.isEmpty()) {
			for(MyCoursesFreeSubCoursesModel myCoursesSuggestionForBuy : buyCoursesSuggestion){					 
				sub_course_id= myCoursesSuggestionForBuy.getSub_course_id();	
				sub_cour_name = myCoursesSuggestionForBuy.getSub_course_name();
				learning_days = myCoursesSuggestionForBuy.getLearning_days();
				price = myCoursesSuggestionForBuy.getPrice();
				sort_id = myCoursesSuggestionForBuy.getSort_id();
				image_link = myCoursesSuggestionForBuy.getImage_link();
				
				course_id = myCoursesSuggestionForBuy.getCourse_id();
				course_name = myCoursesSuggestionForBuy.getCourse_name();
				%>
						
				<div class="course_box course_box_color<%=(i%3)%>">
					<div class="add_image_container">
						<button type="button" id="subject_image_add_short_id_<%= sort_id %>" class="image_button_open_course"
							onclick="BuyCourseDetails('<%= sort_id %>', '<%= projectPath %>')">
							<%if(image_link !=null){%>
								<img src="<%= image_link != null ? image_link : "" %>" class="subcourse_image">
							<%} else{ %>
								<p class="without_image_container without_image_container_color<%=(i%3)%>"><%= sub_cour_name %> </p>
							<%}%>
						</button>
					</div>
					
					<div class="subcourse_details">
						<p class="sub_course_heading"><%= sub_cour_name %></p>
						<p>learning Days(<%= learning_days%> days)	</p>
						<!--  <p>Click (check for detail)</p> -->
						<p>Price - &#8377;<%= price %></p>
						<!--subject/sub_courses -->
						<button type="button" id="subject_open_short_id_<%= sort_id %>" class="course_button" 
							onclick="BuyCourseDetails('<%= sort_id %>', '<%= projectPath %>')" >
							Buy course
						</button>
					</div>
				</div>
			<%i++;}	
		}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}%>