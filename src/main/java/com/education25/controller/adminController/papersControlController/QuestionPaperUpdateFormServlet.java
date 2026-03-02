package com.education25.controller.adminController.papersControlController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.model.adminModel.paperControlModel.QuestionPaperUpdateFormDataGetModel;
import com.education25.service.adminService.authService.AdminVerifyServiceImpl;
import com.education25.service.adminService.papersControlService.QuestionPaperUpdateFormService;
import com.education25.service.adminService.papersControlService.QuestionPaperUpdateFormServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-questions-paper-view-pages/question-update-form")
public class QuestionPaperUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int adminId=0;
		String id=null;
		
		//Verify  this person are admin are not admin  and return true or false.
		HttpSession session = request.getSession();
		adminId=new AdminVerifyServiceImpl().adminVerifyAdminPosition(session);	
		
		if(adminId==0) {
			request.setAttribute("message_error", "You are not login, Please login first");
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/login.jsp");
			rd.forward(request, response);
			return;
		}
		id=request.getParameter("id");
		request.setAttribute("id", id);
		QuestionPaperUpdateFormService service =new QuestionPaperUpdateFormServiceImpl();
		QuestionPaperUpdateFormDataGetModel paperNameBasedOnAdminService = service.getPaperNameBasedOnAdminService(adminId);
		
		if(paperNameBasedOnAdminService.getMessage_error()!=null) {
			request.setAttribute("message_error", paperNameBasedOnAdminService.getMessage_error());
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-questions-paper-view-pages/control-papers.jsp");
			rd.forward(request, response);
			return;
		}
		else {
			request.setAttribute("paperNameList", paperNameBasedOnAdminService.getPaperNameList());
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-questions-paper-view-pages/question-update-form.jsp");
			rd.forward(request, response);
			return;
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}