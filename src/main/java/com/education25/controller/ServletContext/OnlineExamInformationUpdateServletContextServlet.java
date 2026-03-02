package com.education25.controller.ServletContext;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.service.ServletContextService.OnlineExamInformationUpdateServletContextService;
import com.education25.service.ServletContextService.OnlineExamInformationUpdateServletContextServiceImpl;
import com.education25.service.adminService.authService.AdminVerifyServiceImpl;

@WebServlet("/viewPages/admin-view-pages/update-servlet-context/update-onlineExam-context")
public class OnlineExamInformationUpdateServletContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int adminId=0;
	 	String message_error =null;
		boolean result=false;
		
		HttpSession session = request.getSession();
		adminId=new AdminVerifyServiceImpl().adminVerifyAdminPosition(session);	
		
		if(adminId == 1) {
			OnlineExamInformationUpdateServletContextService service =new OnlineExamInformationUpdateServletContextServiceImpl();
			result = service.onlineExamContentSetInServleteContext(request);
			if(!result) {
				message_error ="Failed to update online exam information in ServletContext, Please try again";
			}
		}else {
			message_error ="You are not eligible for update online exam information in ServletContext";
		}
		if(message_error!=null) {
			request.setAttribute("message_error", message_error);
		}else {
			request.setAttribute("message", "Successful update online exam  information in Servlet context");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/update-servlet-context/servlet-context.jsp");
		rd.forward(request, response);
		return;
	}
}