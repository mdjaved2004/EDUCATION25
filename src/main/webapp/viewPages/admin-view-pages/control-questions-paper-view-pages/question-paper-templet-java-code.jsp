<% 

String paper_name=null, total_ques=null, select_que=null, select_marks=null, notSelect_que=null, notSelect_marks=null, total_marks=null;

	paper_name = (String) request.getAttribute("paper_name");
	total_ques = (String) request.getAttribute("total_ques");
	
	//Select_ques=select question which given option.
	select_que = (String) request.getAttribute("select_op_ques");
	select_marks = (String) request.getAttribute("select_op_ques_marks");
	
	//NotSelect_ques=select question which not given option.
	notSelect_que = (String) request.getAttribute("not_select_op_ques");
	notSelect_marks = (String) request.getAttribute("not_select_op_ques_marks");
	
	total_marks = (String) request.getAttribute("total_marks");

%>