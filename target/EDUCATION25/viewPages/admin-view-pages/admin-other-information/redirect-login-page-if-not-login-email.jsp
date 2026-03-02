<%  
	String admin_email=null;
	admin_email = (String) session.getAttribute("admin_email");
	
	if(admin_email==null){	
		 request.setAttribute("message_error", "You are not login, please login first");
		 RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/login.jsp");
		 
		 rd.forward(request, response);
	     return; 
      }
%>