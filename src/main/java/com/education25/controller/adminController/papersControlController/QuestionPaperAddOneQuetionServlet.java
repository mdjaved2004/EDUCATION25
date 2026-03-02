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
import com.education25.model.adminModel.paperControlModel.QuestionPaperQuestionDataModel;
import com.education25.service.adminService.authService.AdminVerifyServiceImpl;
import com.education25.service.adminService.papersControlService.QuestionPaperAddOneQuetionService;
import com.education25.service.adminService.papersControlService.QuestionPaperAddOneQuetionServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-courses-view-pages/add-one-question")
public class QuestionPaperAddOneQuetionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paper_name=null, questionNo=null, id=null, message_error=null, message=null;
		String question=null, option_a=null, option_b=null, option_c=null, option_d=null, answer=null;
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
		
		System.out.println("id= "+id);
		System.out.println("paper_name= "+paper_name);
		System.out.println("questionNo= "+questionNo);
		
		if(id==null || paper_name==null || questionNo==null) {
			request.setAttribute("message_error", "Not find valid information, Please try again.");
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-questions-paper-view-pages/control-papers.jsp");
			rd.forward(request, response);
			return;
		}
		
		question = request.getParameter("new_question" + questionNo);
		option_a = request.getParameter("new_option_a" + questionNo);
		option_b = request.getParameter("new_option_b" + questionNo);
		option_c = request.getParameter("new_option_c" + questionNo);
		option_d = request.getParameter("new_option_d" + questionNo);
		answer = request.getParameter("new_answer" + questionNo);
		
		QuestionPaperQuestionDataModel questionInformationModel = new QuestionPaperQuestionDataModel(Integer.parseInt(questionNo), question, option_a, option_b, option_c, option_d, answer);
		
		
		QuestionPaperAddOneQuetionService serviceForAddNewQuestion= new QuestionPaperAddOneQuetionServiceImpl();
		
		message_error = serviceForAddNewQuestion.addOneQuestionService(questionInformationModel, paper_name);
		
		if(message_error!=null) {
			request.setAttribute("paper_name", paper_name);
			request.setAttribute("id", id);
			request.setAttribute("message_error", message_error);
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-quetion-data-get");
			rd.forward(request, response);
			return;
		}						
		message = "Quetion "+questionNo+" succesful added";
		String redirectData ="&id=" + URLEncoder.encode("update", "UTF-8")
				+ "&paper_name=" + URLEncoder.encode(paper_name, "UTF-8")
				+ "&message=" + URLEncoder.encode(message, "UTF-8");
	
		response.sendRedirect(request.getContextPath() + "/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-quetion-data-get"
			    + "?" + redirectData);
	}
}