<link href="<%=request.getContextPath() %>/css/admin-view-pages-css/common-view-pages-css/message-show.css" type="text/css" rel="stylesheet">
<%
	String message=null,message_error=null;	
	message=(String)request.getAttribute("message");
	message_error=(String)request.getAttribute("message_error");
	
	if(message==null && message_error==null){
		message= request.getParameter("message");
		message_error= request.getParameter("message_error");	
	}
%>
<script>
	    var successMessage = "<%= message != null ? message : "" %>";
	    var errorMessage = "<%= message_error != null ? message_error : "" %>";
</script>

<script src="<%=request.getContextPath() %>/js/admin-view-pages-js/common-view-pages/message-show.js"></script>