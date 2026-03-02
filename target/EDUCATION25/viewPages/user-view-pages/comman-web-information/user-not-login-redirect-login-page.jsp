<%  
    String user_userName = (String) session.getAttribute("user_userName");
    
    if(user_userName == null){	
        request.setAttribute("message_error", "You are not login, please login first");
        RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/login-page.jsp");
        
        rd.forward(request, response);
        return; 
    }
%>
	
	
