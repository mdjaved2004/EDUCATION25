package com.education25.controller.adminController.papersControlController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.service.adminService.authService.AdminVerifyServiceImpl;
import com.education25.service.adminService.papersControlService.QuestionPaperUpdateFormCheckService;
import com.education25.service.adminService.papersControlService.QuestionPaperUpdateFormCheckServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-questions-paper-view-pages/question-update-form-check")
public class QuestionPaperUpdateFormCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paper_name=null, form_id=null, pageRedirect=null, message_error=null;
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
		
		form_id=request.getParameter("id");		
		paper_name= request.getParameter("paper_name");
				
		QuestionPaperUpdateFormCheckService checkPaperNameService= new QuestionPaperUpdateFormCheckServiceImpl();
		message_error = checkPaperNameService.checkPaperNameExistService(adminId, paper_name);
		
		if(message_error!=null) {
			request.setAttribute("message_error", message_error);
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-questions-paper-view-pages/question-update-form");
			rd.forward(request, response);
			return;			
		}else {
			request.setAttribute("id", form_id);
			request.setAttribute("paper_name", paper_name);
			if(form_id!=null) {
				switch (form_id) {
		            case "update":
		            		pageRedirect = "/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-quetion-data-get";
		                break;
		                
		            case "deletePaper":
		            		pageRedirect ="/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-quetion-data-get";
		//            		"/viewPages/admin-view-pages/control-courses-view-pages1/sub-course-delete-view";
		            		break;
		            		
		            case "updateImage":
		        			pageRedirect = "/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-update-image-view";
		        			break;
		            	
		            default:
		        			request.setAttribute("message_error", "Not find this page, Please try again");
		                pageRedirect = "/viewPages/admin-view-pages/control-questions-paper-view-pages/control-papers.jsp";
		    		}
			}else {
				request.setAttribute("message_error", "Not find this page, Please try again1");
				pageRedirect = "/viewPages/admin-view-pages/control-questions-paper-view-pages/control-papers.jsp";
			}
			RequestDispatcher rd = request.getRequestDispatcher(pageRedirect);
			rd.forward(request, response);		
		}
	}
}