package com.education25.controller.adminController.papersControlController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.model.adminModel.paperControlModel.QuestionPaperTempletCheckModel;
import com.education25.service.adminService.authService.AdminVerifyServiceImpl;
import com.education25.service.adminService.papersControlService.QuestionPaperTempletCheckService;
import com.education25.service.adminService.papersControlService.QuestionPaperTempletCheckServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-questions-paper-view-pages/ques_paper_templet_check")
public class QuestionPaperTempletCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String paper_name=null, total_ques=null, select_que=null, select_marks=null, notSelect_que=null, notSelect_marks=null, total_marks=null, message_error=null;
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
		total_ques = request.getParameter("total_ques");
		
		//Select_ques=select question which given option.
		select_que = request.getParameter("select_op_ques");
		select_marks = request.getParameter("select_op_ques_marks");
		
		//NotSelect_ques=select question which not given option.
		notSelect_que = request.getParameter("not_select_op_ques");
		notSelect_marks = request.getParameter("not_select_op_ques_marks");
		
		total_marks = request.getParameter("total_marks");
		
		//Set value for further process
		request.setAttribute("paper_name", paper_name);
		request.setAttribute("total_ques", total_ques);
		request.setAttribute("select_op_ques", select_que);
		request.setAttribute("select_op_ques_marks", select_marks);
		request.setAttribute("not_select_op_ques", notSelect_que);
		request.setAttribute("not_select_op_ques_marks", notSelect_marks);
		request.setAttribute("total_marks", total_marks);
		
		if(paper_name==null || total_ques==null || select_que==null || select_marks==null || notSelect_que==null || notSelect_marks==null || total_marks==null) {
			request.setAttribute("message_error", "Inpuut box Empty not allow, Please Fill Every Field");
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-templet.jsp");
			rd.forward(request, response);
			return;
		}

		QuestionPaperTempletCheckModel quesPaperbasicInfoFormModel = new QuestionPaperTempletCheckModel(paper_name, total_ques, select_que, select_marks, notSelect_que, notSelect_marks, total_marks, message_error);
		
		QuestionPaperTempletCheckService checkInfoService =new QuestionPaperTempletCheckServiceImpl();
		
		QuestionPaperTempletCheckModel checkInformationService = checkInfoService.checkInformationService(quesPaperbasicInfoFormModel);
		
		if(checkInformationService.getMessage_error()==null) {
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-questions-paper-view-pages/question-insert.jsp");
			rd.forward(request, response);
			return;
		}else {
			request.setAttribute("message_error", checkInformationService.getMessage_error());
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-templet.jsp");
			rd.forward(request, response);
			return;
		}
	}
}