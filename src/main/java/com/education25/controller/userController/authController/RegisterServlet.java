package com.education25.controller.userController.authController;

import java.io.IOException;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.model.userModel.authModel.RegisterFormInformationModel;
import com.education25.service.userService.authService.RegisterServiceImpl;
import com.education25.util.mail.UserRegisterSendOtpMail;
import com.education25.util.mail.UserRegisterSendOtpMailImpl;

@WebServlet("/viewPages/user-view-pages/auth-view-pages/resister")
public class RegisterServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullName=null, email=null, userName=null, password=null, confirmPassword=null;
		
		HttpSession session = request.getSession();
		
		fullName = request.getParameter("fullName");
		email = request.getParameter("email");
		userName = request.getParameter("username");
		password = request.getParameter("password");
		confirmPassword = request.getParameter("confirmPassword"); 
		
		if(fullName!=null)fullName=fullName.trim();
		if(email!=null)email=email.trim();
		if(userName!=null)userName=userName.trim();
		if(password!=null)password=password.trim();
		if(confirmPassword!=null)confirmPassword=confirmPassword.trim();
		 
		if(fullName==null || email==null || userName==null || password==null || confirmPassword==null) {
			request.setAttribute("message_error", "All fields are required. Please complete the form.");
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/resister-page.jsp");
			rd.forward(request, response);
			return;
		}
		 
		// Temporary store user input value into RegisterFormInformationModel.
		RegisterFormInformationModel registerFormModel = new RegisterFormInformationModel(fullName, email, userName, password, confirmPassword);

		RegisterServiceImpl service = new RegisterServiceImpl();
		System.out.println("==============Task1");
		//checkValidation method call in Service class for input field validation.
		String validationError= service.checkValidation(registerFormModel);
		 
		//if any validation error then redirect resister-page.jsp.
	    if (validationError != null) {
	    		request.setAttribute("message_error", validationError);
            RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/resister-page.jsp");
			rd.forward(request, response);
			return;
        }
	    
	    //if all validation is pass then continue this process.
	    // Generate 6 digit random  OTP for user verification.
	     Random random = new Random();
	     int otp = 100000 + random.nextInt(900000); 
	     
	     //create object in mail class.
	     UserRegisterSendOtpMail sendMailImpl = new UserRegisterSendOtpMailImpl();
	     
	     // this method send mail for user.
	     boolean mailResultmessage = sendMailImpl.userRegisterSendOtpInMail(registerFormModel.getFullName(), registerFormModel.getEmail(), otp);

	    if(mailResultmessage) {
	    	   	 session.setAttribute("user_name", registerFormModel.getFullName());
		    	 session.setAttribute("user_email", registerFormModel.getEmail());
		    	 session.setAttribute("user_userName", registerFormModel.getUserName());
		    	 session.setAttribute("user_password_temp", registerFormModel.getPassword());
		    	 session.setAttribute("mail_otp_temp",otp);
		    	 RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/resister-otp-verification.jsp");
			 rd.forward(request, response);
			 return;
	     }else {
	    	 	request.setAttribute("message_error", "Registration failed. please try agian.");
	    	 	RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/resister-page.jsp");
			rd.forward(request, response);
			return;
	     }
	}	
}