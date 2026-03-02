package com.education25.controller.userController.authController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.model.userModel.authModel.RegisterFormInformationModel;
import com.education25.model.userModel.authModel.RegisterReturnModel;
import com.education25.service.userService.authService.RegisterServiceImpl;

@WebServlet("/viewPages/user-view-pages/auth-view-pages/resister_after_otp_verification")
public class ResisterAfterOtpVerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String fullName=null, email=null, userName=null, password=null;
		String inp=null, userOTPString="";
		int user_otp=0,mailOTP=0;	
		
		if((String)session.getAttribute("user_name")!=null) {			
			fullName =(String)session.getAttribute("user_name");
			email = (String)session.getAttribute("user_email");
			userName =(String)session.getAttribute("user_userName");
			password = (String)session.getAttribute("user_password_temp");
		}
		if(session.getAttribute("mail_otp_temp")!=null) {			
			mailOTP=(int)session.getAttribute("mail_otp_temp");
		}
		
		if(fullName!=null)fullName=fullName.trim();
		if(email!=null)email=email.trim();
		if(userName!=null)userName=userName.trim();
		if(password!=null)password=password.trim();
		
		//check session value null 
		if(fullName==null || email==null || userName==null || password==null) {
			request.setAttribute("message_error", "Registration failed. please try agian");
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/resister-page.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		for(int i=1;i<=6;i++) {
			inp=request.getParameter("inp"+i+"");
			if(inp!=null) {
				userOTPString +=inp;
			}
		}
		if(userOTPString!=null) {
			user_otp = Integer.parseInt(userOTPString);
		}
		if(mailOTP!=user_otp) {
			request.setAttribute("message_error", "You are enter wrong input, try again");
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/resister-otp-verification.jsp");
			rd.forward(request, response);
			return;
		}
			
		
		// Temporary store user input value into RegisterFormInformationModel.
		RegisterFormInformationModel registerFormModel = new RegisterFormInformationModel(fullName, email, userName, password, password);
				
		RegisterServiceImpl service = new RegisterServiceImpl();
		
		RegisterReturnModel registerService = service.registerService(registerFormModel);
		
	    if(registerService.getMessageError()!=null) {
			request.setAttribute("message_error", registerService.getMessageError());
	    		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/resister-page.jsp");
			rd.forward(request, response);
			return;
	    }else {
		    	session.removeAttribute("user_password_temp");
		    	session.removeAttribute("mail_otp_temp");
		    	
	    		session.setAttribute("user_id",  Integer.toString(registerService.getUserId()));
            session.setAttribute("user_name", registerFormModel.getFullName());
            session.setAttribute("user_email", registerFormModel.getEmail());
            session.setAttribute("user_userName", registerFormModel.getUserName());
                  
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return;
	    }	    
	}
}
