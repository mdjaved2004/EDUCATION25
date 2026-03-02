package com.education25.controller.ServletContext;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.service.ServletContextService.CoursesInformationUpdateServletContextService;
import com.education25.service.ServletContextService.CoursesInformationUpdateServletContextServiceImpl;
import com.education25.service.adminService.authService.AdminVerifyServiceImpl;

@WebServlet("/viewPages/admin-view-pages/update-servlet-context/update-course-context")
public class CoursesInformationUpdateServletContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	int adminId=0;
	 	String message_error =null;
		boolean result=false;
		
		HttpSession session = request.getSession();
		adminId=new AdminVerifyServiceImpl().adminVerifyAdminPosition(session);	
		
		if(adminId == 1) {
			CoursesInformationUpdateServletContextService service =new CoursesInformationUpdateServletContextServiceImpl();
			result = service.courseContentSetInServleteContext(request);
			if(!result) {
				message_error ="Failed to update course information in ServletContext, Please try again";
			}
		}else {
			message_error ="You are not eligible for update Course information in ServletContext";
		}
		if(message_error!=null) {
			request.setAttribute("message_error", message_error);
		}else {
			request.setAttribute("message", "Successful update course information in Servlet context");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/update-servlet-context/servlet-context.jsp");
		rd.forward(request, response);
		return;
	}
}