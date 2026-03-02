package com.education25.controller.userController.onlineExamAndCertificateController;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.model.userModel.onlineExamAndCertificateModel.GetCertificateModel;
import com.education25.service.userService.coursesService.UserLoginCheckServiceImpl;
import com.education25.service.userService.onlineExamAndCertificateService.GetCertificateService;
import com.education25.service.userService.onlineExamAndCertificateService.GetCertificateServiceImpl;

@WebServlet("/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/GetCertificate")
public class GetCertificateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String message_error=null;
		int user_id=0;
		
	    user_id = new UserLoginCheckServiceImpl().userLoginAndIdReturnId(session);
	    if(user_id <= 0) {
			message_error = "You Are Not Login , Please Login First";
			request.setAttribute("message_error", message_error);
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/login-page.jsp");
			rd.forward(request, response);
			return;
		}
	    
	    GetCertificateService service=new GetCertificateServiceImpl();
		
		List<GetCertificateModel> certificateRecords = service.getCertificateRecords(user_id);
		
		request.setAttribute("testRecords", certificateRecords);
		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/get-certificate.jsp");
		rd.forward(request, response);
		return;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}