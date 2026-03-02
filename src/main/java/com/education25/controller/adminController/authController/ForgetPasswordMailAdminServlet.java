package com.education25.controller.adminController.authController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.education25.service.adminService.authService.ForgetPasswordAdminService;
import com.education25.service.adminService.authService.ForgetPasswordAdminServiceImpl;

@WebServlet("/viewPages/admin-view-pages/auth-view-pages/forget-password")
public class ForgetPasswordMailAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_email = request.getParameter("email");
		
		if(user_email!=null)user_email=user_email.trim();
		
		if(user_email==null) {
			request.setAttribute("message_error","email is empty, try again");
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/forget-password.jsp");
			rd.forward(request, response);
			return;
		}
		
		ForgetPasswordAdminService service= new ForgetPasswordAdminServiceImpl();
		
		//This method is service layer to check email validation.
		//if no any error then return null string.
		String checkValidation = service.checkValidation(user_email);
		
		if(checkValidation!=null) {
			request.setAttribute("message_error",checkValidation);
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/forget-password.jsp");
			rd.forward(request, response);
			return;
		}
	   String forgetPasswordSendMail = service.forgetPasswordSendMail(user_email);

	   if(forgetPasswordSendMail==null) {
		   	request.setAttribute("message","check your email to send user name and password ");
		   	RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/login.jsp");
			rd.forward(request, response);
			return;  
	   }else {
		   	request.setAttribute("message_error", forgetPasswordSendMail);
		   	RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/forget-password.jsp");
			rd.forward(request, response);
			return; 
	   }  	
	}
}