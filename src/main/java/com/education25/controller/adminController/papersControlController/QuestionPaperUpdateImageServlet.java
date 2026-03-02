package com.education25.controller.adminController.papersControlController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.education25.service.ServletContextService.QuestionPaperUpdateImageLinkServletContextServiceImpl;
import com.education25.service.adminService.authService.AdminVerifyServiceImpl;
import com.education25.service.adminService.papersControlService.QuestionPaperUpdateImageService;
import com.education25.service.adminService.papersControlService.QuestionPaperUpdateImageServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-update-image")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2,   // 1 MB (memory threshold)
    maxFileSize = 1024 * 1024 * 2,          // 1 MB (single file max)
    maxRequestSize = 1024 * 1024 * 2  + 1024       // 1 MB + 1kb (total request size)
)
public class QuestionPaperUpdateImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paper_name=null, paper_id =null, form_id=null, old_image_link=null, pageRedirect=null, message_error=null;
		int AdminId=0;
		String[] updateImageImageService =new String[2];
		Part image_input =null;
		
		HttpSession session = request.getSession();
		
		AdminId=new AdminVerifyServiceImpl().adminVerifyAdminPosition(session);
		if(AdminId==0) {
			request.setAttribute("message_error", "You are not login, Please login first");
	    	 	RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/login.jsp");
			rd.forward(request, response);
			return;
		}
	  
		form_id=request.getParameter("id");
		paper_name= request.getParameter("paper_name");
		paper_id= request.getParameter("paper_id");
		old_image_link = request.getParameter("image_link");
		
		image_input = request.getPart("image_input");
		
		request.setAttribute("id", form_id);
		request.setAttribute("paper_name", paper_name);
		request.setAttribute("paper_id", paper_id);
		
		if(form_id==null || paper_name==null || paper_id==null || image_input == null) {
			message_error ="Wrong activity , Try Again";
			request.setAttribute("image_link", old_image_link);
			request.setAttribute("messgae_error", message_error);
			
			pageRedirect = "/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-update-image.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(pageRedirect);
			rd.forward(request, response);
			return;
		}
		
		QuestionPaperUpdateImageService  service= new QuestionPaperUpdateImageServiceImpl();
		
		updateImageImageService = service.updateImageImageService(paper_name, paper_id, image_input, request.getContextPath(), AdminId);
		
		if(updateImageImageService[0]!=null) {
			request.setAttribute("image_link", old_image_link);
			request.setAttribute("messgae_error", message_error);
			pageRedirect = "/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-update-image.jsp";
		}else {
			//Update Image in ServletContext.
			new QuestionPaperUpdateImageLinkServletContextServiceImpl().updateLink(request, Integer.parseInt(paper_id), paper_name, updateImageImageService[1]);
			
			request.setAttribute("message", "Succesfull update Image");
			pageRedirect = "/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-update-image-view";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(pageRedirect);
		rd.forward(request, response);
		return;    
   }
}