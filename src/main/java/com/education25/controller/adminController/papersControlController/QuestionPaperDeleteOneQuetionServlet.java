package com.education25.controller.adminController.papersControlController;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.service.adminService.authService.AdminVerifyServiceImpl;
import com.education25.service.adminService.papersControlService.QuestionPaperDeleteOneQuetionService;
import com.education25.service.adminService.papersControlService.QuestionPaperDeleteOneQuetionServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-courses-view-pages/delete-one-question")
public class QuestionPaperDeleteOneQuetionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paper_name=null, questionNo=null, id=null, message_error=null, message=null;
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
		
		id = request.getParameter("id");		
		paper_name = request.getParameter("paper_name");
		questionNo = request.getParameter("questionNo");
		
		if(id==null || paper_name==null || questionNo==null) {
			request.setAttribute("message_error", "Not find valid information, Please try again.");
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-questions-paper-view-pages/control-papers.jsp");
			rd.forward(request, response);
			return;
		}
		
		QuestionPaperDeleteOneQuetionService serviceForDeleteOneQuestion= new QuestionPaperDeleteOneQuetionServiceImpl();
		
		message_error = serviceForDeleteOneQuestion.deleteOneQuestionService(paper_name, questionNo);
		
		if(message_error!=null) {
			request.setAttribute("paper_name", paper_name);
			request.setAttribute("id", id);
			request.setAttribute("message_error", message_error);
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-quetion-data-get");
			rd.forward(request, response);
			return;
		}						
		message = "Quetion "+questionNo+" succesful deleted";
		String redirectData ="&id=" + URLEncoder.encode("update", "UTF-8")
				+ "&paper_name=" + URLEncoder.encode(paper_name, "UTF-8")
				+ "&message=" + URLEncoder.encode(message, "UTF-8");
	
		response.sendRedirect(request.getContextPath() + "/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-quetion-data-get"
			    + "?" + redirectData);
	}
}