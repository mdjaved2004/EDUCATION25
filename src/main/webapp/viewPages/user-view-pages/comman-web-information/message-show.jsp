<link href="<%=request.getContextPath() %>/css/user-view-pages-css/courses-view-pages-css/message-show.css" type="text/css" rel="stylesheet">
<%
	String message=null,message_error=null;	
	message=(String)request.getAttribute("message");
	message_error=(String)request.getAttribute("message_error");
%>
<script>
	    var successMessage = "<%= message != null ? message : "" %>";
	    var errorMessage = "<%= message_error != null ? message_error : "" %>";
</script>

<script src="<%=request.getContextPath() %>/js/user-view-pages-js/courses-view-pages-js/message-show.js"></script>
