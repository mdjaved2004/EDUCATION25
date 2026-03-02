<%	String course_name=null, sub_course_name=null, learning_days=null, price=null;
	int course_id= 0;
	
	course_id = (int) request.getAttribute("course_id");
	course_name = (String) request.getAttribute("course_name");
	sub_course_name = (String) request.getAttribute("sub_course_name");
	learning_days = (String) request.getAttribute("learning_days");
	price = (String) request.getAttribute("price");
%>
	<input type="hidden" name="course_id" value="<%= course_id %>">
    <input type="hidden" name="course_name" value="<%= course_name %>">
    <input type="hidden" name="sub_course_name" value="<%= sub_course_name %>">
    <input type="hidden" name="learning_days" value="<%= learning_days %>">
    <input type="hidden" name="price" value="<%= price %>">