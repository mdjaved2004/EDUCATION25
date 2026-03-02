<%  
	String admin_userName=null;
	admin_userName = (String) session.getAttribute("admin_userName");
	
	if(admin_userName==null){	
		request.setAttribute("message_error", "You are not login , please login first");
		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/login.jsp");
		rd.forward(request, response);
        return; 
      }
%>