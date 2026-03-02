<%
	String id =null, course_name=null, course_id=null, sub_course_name=null, sub_course_short_id=null, image_link=null, price=null, learning_days=null;
	
	id= (String) request.getAttribute("id");
	course_name= (String) request.getAttribute("course_name");
	course_id= (String) request.getAttribute("course_id");
	sub_course_name= (String) request.getAttribute("sub_course_name");
	sub_course_short_id= (String) request.getAttribute("sub_course_short_id");
	image_link = (String) request.getAttribute("image_link");
	price = (String) request.getAttribute("price");
	learning_days = (String) request.getAttribute("learning_days");
	
	int random = (int)(Math.random() * 4);
%>
