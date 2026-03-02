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
import com.education25.util.mail.UserRegisterSendOtpMail;
import com.education25.util.mail.UserRegisterSendOtpMailImpl;

@WebServlet("/viewPages/user-view-pages/auth-view-pages/resister_recend_otp")
public class ResisterResendOtpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String resis_full_name=null,resis_email=null;
		
		if(session.getAttribute("user_name_temp")!=null) {
			resis_full_name =(String)session.getAttribute("user_name");
			resis_email =(String)session.getAttribute("user_email");		
			Random random = new Random();
		    int otp = 100000 + random.nextInt(900000);
		     
		    UserRegisterSendOtpMail sendMailImpl = new UserRegisterSendOtpMailImpl();
		    boolean mailresultMessage = sendMailImpl.userRegisterSendOtpInMail(resis_full_name, resis_email, otp);
			if(mailresultMessage) {
				session.setAttribute("mail_otp_temp",otp); 
				RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/resister-otp-verification.jsp");
				rd.forward(request, response);
				return;		
			}
		}
		
		request.setAttribute("message_error", "Resend OTP failed. back and try again"); 
		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/resister-otp-verification.jsp");
		rd.forward(request, response);
		return;	
	}
}