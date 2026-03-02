<%@page import="com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_"%>
<%
		String course_name=null, course_id= null, sub_course_name =null, sub_course_id = null, price = null, sortId = null, image_link = null;
		int course_id_int=0, sortId_int=0;
        
		course_name = (String) request.getAttribute("course_name");
		course_id = (String) request.getAttribute("course_id");
		sub_course_name = (String) request.getAttribute("sub_course_name");
		sub_course_id = (String) request.getAttribute("sub_course_id");
		price = (String) request.getAttribute("price");
		image_link =(String) request.getAttribute("image_link");
		sub_course_id = (String) request.getAttribute("sub_course_id");
		sortId = (String) request.getAttribute("sortId");
		
		if(course_id!=null){
			course_id_int = Integer.parseInt(course_id);
		}
		if(sortId!=null){
			sortId_int = Integer.parseInt(sortId);
		}
    %>