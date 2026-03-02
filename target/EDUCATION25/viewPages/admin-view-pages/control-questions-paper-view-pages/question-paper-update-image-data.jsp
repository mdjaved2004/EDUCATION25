<%
	String paper_name=null, id=null, image_link=null;
	int paper_id =0, total_ques=0;
	id = (String) request.getAttribute("id");
	paper_name = (String) request.getAttribute("paper_name");
	paper_id= (int) request.getAttribute("paper_id");
	image_link= (String) request.getAttribute("image_link");
	total_ques= (int) request.getAttribute("total_ques");

%>