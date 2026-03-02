<% 
	String paper_name=null, total_ques=null, select_ques=null, select_marks=null, notSelect_ques=null, notSelect_marks=null, total_marks=null;
	int total_ques_int=0, select_que_int=0, select_marks_int=0, notSelect_que_int=0, notSelect_marks_int=0, total_marks_int=0;
	
	paper_name = (String) request.getAttribute("paper_name");
	total_ques = (String) request.getAttribute("total_ques");
	
	//Select_ques=select question which given option.
	select_ques = (String) request.getAttribute("select_op_ques");
	select_marks = (String) request.getAttribute("select_op_ques_marks");
	
	//NotSelect_ques=select question which not given option.
	notSelect_ques = (String) request.getAttribute("not_select_op_ques");
	notSelect_marks = (String) request.getAttribute("not_select_op_ques_marks");
	
	total_marks = (String) request.getAttribute("total_marks");
	
	if(total_ques!=null){
		total_ques_int = Integer.parseInt(total_ques);		
	}
	if(select_ques!=null){
		select_que_int = Integer.parseInt(select_ques);		
	}
	if(select_marks!=null){
		select_marks_int = Integer.parseInt(select_marks);		
	}
	if(notSelect_ques!=null){
		notSelect_que_int = Integer.parseInt(notSelect_ques);		
	}
	if(notSelect_marks!=null){
		notSelect_marks_int = Integer.parseInt(notSelect_marks);		
	}
	if(total_marks!=null){
		total_marks_int = Integer.parseInt(total_marks);		
	}

%>