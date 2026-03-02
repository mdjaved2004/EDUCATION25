package com.education25.controller.adminController.papersControlController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.education25.service.ServletContextService.DeleteOnePaperServletContextServiceImpl;
import com.education25.service.adminService.authService.AdminVerifyServiceImpl;
import com.education25.service.adminService.papersControlService.QuestionPaperDeleteService;
import com.education25.service.adminService.papersControlService.QuestionPaperDeleteServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-courses-view-pages/delete-paper")
public class QuestionPaperDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paper_name=null, message_error=null;
		int adminId=0;
		
		//Verify  this person are admin are not admin  and return true or false.
		HttpSession session = request.getSession();
		adminId=new AdminVerifyServiceImpl().adminVerifyAdminPosition(session);	
		
		if(adminId==0) {
			request.setAttribute("message_error", "You are not login, Please login first");
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/login.jsp");
			rd.forward(request, response);
			return;
		}
		
		paper_name = request.getParameter("paper_name");
		
		QuestionPaperDeleteService serviceForDeletePaper= new QuestionPaperDeleteServiceImpl();

		message_error = serviceForDeletePaper.deletePaperService(paper_name, adminId);
		
		if(message_error!=null) {
			request.setAttribute("message_error", message_error);
		}else {
			new DeleteOnePaperServletContextServiceImpl().deleteOnePaper(request, paper_name);
			request.setAttribute("message", "Paper "+paper_name+" succesful deleted");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-questions-paper-view-pages/control-papers.jsp");
		rd.forward(request, response);
		return;
	}
}