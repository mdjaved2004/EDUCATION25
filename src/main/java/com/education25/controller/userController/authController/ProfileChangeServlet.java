package com.education25.controller.userController.authController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.service.userService.authService.ProfileChangeService;
import com.education25.service.userService.authService.ProfileChangeServiceImpl;
import com.education25.service.userService.coursesService.UserLoginCheckService;
import com.education25.service.userService.coursesService.UserLoginCheckServiceImpl;

@WebServlet("/viewPages/user-view-pages/user-information-view-pages/profileChange")
public class ProfileChangeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    		String full_name=null, user_name=null, getNameInseesion = null, getUsernameInSession = null, message_error=null;
    		int user_id=0;
    		
    		HttpSession session = request.getSession();
    		
    		UserLoginCheckService userInfoGetInSession=new UserLoginCheckServiceImpl();
    	    
    		user_id = userInfoGetInSession.userLoginAndIdReturnId(session);
    	     
    	    if(user_id <= 0) {
    			message_error = "You Are Not Login , Please Login First";
    			request.setAttribute("message_error", message_error);
    			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/login-page.jsp");
			rd.forward(request, response);
			return;
    		}
    		
    	    full_name = request.getParameter("full_name");
    	    user_name = request.getParameter("username");
    	    
    	    if(full_name!=null)full_name=full_name.trim();
    	    if(user_name!=null)user_name=user_name.trim();
    	    
    	    getNameInseesion = userInfoGetInSession.getName(session);
    	    getUsernameInSession =userInfoGetInSession.getUserName(session);
    	    
    	    if(full_name.equals(getNameInseesion) && user_name.equals(getUsernameInSession)) {
    	    		request.setAttribute("message", "Successful update profile");
    	    		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/user-information-view-pages/profile.jsp");
    	    	    rd.forward(request, response);
    	    	    return;
    	    }
    	    
    	    if(full_name==null || user_name==null || full_name.strip().isEmpty() || user_name.isEmpty()){
    	    		message_error = "Fill Full Name and UserName";
    			request.setAttribute("message_error", message_error);
    			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/user-information-view-pages/profile.jsp");
			rd.forward(request, response);
			return;
    	    }
    	    
    	    ProfileChangeService service= new ProfileChangeServiceImpl();
    	    message_error = service.updateProfileService(user_id, full_name, user_name);
    	    
    	    if(message_error!=null) {
    			request.setAttribute("message_error", message_error);
    	    }else {
    	    		request.setAttribute("message", "Successful update profile");  
    	    		session.setAttribute("user_name", full_name);
    			session.setAttribute("user_userName", user_name);
    	    }
    	    RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/user-information-view-pages/profile.jsp");
    	    rd.forward(request, response);
    	    return;
    }
}