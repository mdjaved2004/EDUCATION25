package com.education25.controller.userController.onlineExamAndCertificateController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.model.userModel.onlineExamAndCertificateModel.ExamStartModel;
import com.education25.service.userService.onlineExamAndCertificateService.ExamStartServiceImpl;

@WebServlet("/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/exam-start")
public class ExamStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    	//<!-- `paper_id`, `paper_Name`, `total_ques`, `option_ques`, `notOption_ques` -->
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user_email=null, paperName=null, paperIdString=null;
		int paperId=0;
		user_email=(String)session.getAttribute("user_email");
	    if(user_email==null) {
			request.setAttribute("message_error", "You are not login, Please Login First");
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/login-page.jsp");
			rd.forward(request, response);
			return;	
		}
	    paperName = request.getParameter("paperName");
	    paperIdString = request.getParameter("paperId");
	 
	    if(paperName==null && paperIdString==null) {
	    		request.setAttribute("message_error", "Somethink went wrong, Please try again");
	    		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/online-exam.jsp");
			rd.forward(request, response);
			return;	
	    }else {
	    		paperId=Integer.parseInt(paperIdString);
	    }
	    
	    ExamStartModel examStartContent = new ExamStartServiceImpl().getExamStartContext(paperName, paperId);
	    
	    if(examStartContent.getPaperInfo()!=null) {
	    		request.setAttribute("examStartContent", examStartContent);
	    		
	    		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/online-exam-test-start-paper.jsp");
			rd.forward(request, response);
			return;
	    	
	    }else {
	    		System.out.println("task2");
		    	request.setAttribute("message_error", "Somethink went wrong, Please try again");
	    		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/online-exam.jsp");
			rd.forward(request, response);
			return;	
	    }
	}
}