package com.education25.controller.userController.onlineExamAndCertificateController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.model.userModel.commonModel.MessageAndErrormessageModel;
import com.education25.model.userModel.onlineExamAndCertificateModel.ExamStartPaperInformation;
import com.education25.service.userService.onlineExamAndCertificateService.ExamCopyCheckServiceImpl;

@WebServlet("/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/copyCheck")
public class ExamCopyCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String paperName=null;	
		String paperIdString=null, totalQuestionsString = null, optionQuestionsString = null, notOptionQuestionsString = null;
		int user_resister_id=0;
		
		String user_resister_id_string= (String) session.getAttribute("user_id");
		
		paperIdString = request.getParameter("paperId");
		paperName = request.getParameter("paperName");
		totalQuestionsString = request.getParameter("totalQuestions");
		optionQuestionsString = request.getParameter("optionQuestions");
		notOptionQuestionsString = request.getParameter("notOptionQuestions");
		
		ExamStartPaperInformation paperInforStore=null;
		
		if(paperName!=null && paperIdString!=null && totalQuestionsString!=null && optionQuestionsString!=null && notOptionQuestionsString!=null && user_resister_id_string!=null) {
			user_resister_id=Integer.parseInt(user_resister_id_string);
			paperInforStore=new ExamStartPaperInformation(
					Integer.parseInt(paperIdString),
					paperName,
					Integer.parseInt(totalQuestionsString),
					Integer.parseInt(optionQuestionsString),
					Integer.parseInt(notOptionQuestionsString)
					);
			
		}else {
			if(user_resister_id_string==null) {
				request.setAttribute("message_error", "You are not identify, try again");			
			}else {
				request.setAttribute("message_error", "Unusual activity detected. Your exam has been reset.");	
			}
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/online-exam-test-start-paper.jsp");
			rd.forward(request, response);
			return;
		}
		
		//Define String Array for Store answer Data
		String resultStore[]= new String[paperInforStore.getTotal_ques()];
		
		//Get All ans which selected user ,if not selected then null value		
		for(int i=0;i<paperInforStore.getTotal_ques();i++) {
			String userAns=request.getParameter("answer_" +(i+1));
			if(!userAns.equals("null")) {
				resultStore[i]=userAns;
			}
		}
		MessageAndErrormessageModel messageServive = new ExamCopyCheckServiceImpl().copyCkeckAndStoreDataServive(user_resister_id, resultStore, paperInforStore);
		
		if(messageServive.getMessage()!=null) {
			request.setAttribute("message", messageServive.getMessage());			
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/GetCertificate");
			rd.forward(request, response);
			return;
		}else {
			request.setAttribute("message_error", messageServive.getMessage_error());	
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/online-exam-test-start-paper.jsp");
			rd.forward(request, response);
			return;
		}	
	}
}