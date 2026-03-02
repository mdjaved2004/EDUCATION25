package com.education25.controller.adminController.papersControlController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.education25.model.adminModel.paperControlModel.QuetionPaperFullInformationWithMessageErrorModel;
import com.education25.service.adminService.papersControlService.QuestionPaperQuestionDataGetService;
import com.education25.service.adminService.papersControlService.QuestionPaperQuestionDataGetServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-quetion-data-get")
public class QuestionPaperQuestionDataGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paper_name=null, id=null, redirect_page=null;
		boolean dataSet=true;
		
		paper_name= (String) request.getAttribute("paper_name");
		id = (String) request.getAttribute("id");
		
		QuestionPaperQuestionDataGetService serviceGetInfo= new QuestionPaperQuestionDataGetServiceImpl();
		
		QuetionPaperFullInformationWithMessageErrorModel paperFullInfo = serviceGetInfo.getInforService(paper_name);
		
		if(paperFullInfo.getMessage_error()!=null) {
			request.setAttribute("message_error", paperFullInfo.getMessage_error());
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-questions-paper-view-pages/control-papers.jsp");
			rd.forward(request, response);
			return;
		}else {
			switch(id) {
				case "update": redirect_page="/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-update-question.jsp";
							   break;
				
				case "deletePaper": redirect_page="/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-before-delete.jsp";
									break;	
				default:	dataSet=false;
						request.setAttribute("message_error", "Something wrong try again");
						redirect_page="/viewPages/admin-view-pages/control-questions-paper-view-pages/control-papers.jsp";	
			}
			
		}
		if(dataSet) {
			request.setAttribute("paperInformation", paperFullInfo.getPaperInformation());
			request.setAttribute("questionInfoList", paperFullInfo.getQuestionInfoList());	
		}
		RequestDispatcher rd = request.getRequestDispatcher(redirect_page);
		rd.forward(request, response);
		return;				
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paper_name=null,id=null;
		id = request.getParameter("id");		
		paper_name = request.getParameter("paper_name");
		
		request.setAttribute("paper_name", paper_name);
		request.setAttribute("id", id);
		
		doPost(request, response);
	}
}
