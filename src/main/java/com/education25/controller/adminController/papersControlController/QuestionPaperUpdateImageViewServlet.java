package com.education25.controller.adminController.papersControlController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.education25.model.adminModel.paperControlModel.PaperInformationForImageUpdateModel;
import com.education25.service.adminService.papersControlService.QuestionPaperUpdateImageViewService;
import com.education25.service.adminService.papersControlService.QuestionPaperUpdateImageViewServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-update-image-view")
public class QuestionPaperUpdateImageViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paper_name=null, pageRedirect=null;
		
		paper_name = (String) request.getAttribute("paper_name");

		QuestionPaperUpdateImageViewService service= new QuestionPaperUpdateImageViewServiceImpl();
		
		PaperInformationForImageUpdateModel paperInfoService = service.getPaperInfoService(paper_name);
		
		if(paperInfoService.getMessage_error()!=null) {
			request.setAttribute("message_error", paperInfoService.getMessage_error());
			pageRedirect = "/viewPages/admin-view-pages/control-questions-paper-view-pages/control-papers.jsp";		
		}else {
			request.setAttribute("paper_id", paperInfoService.getPaper_id());
			request.setAttribute("image_link", paperInfoService.getImage_link());
			request.setAttribute("total_ques", paperInfoService.getTotal_ques());
			
			pageRedirect = "/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-update-image.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(pageRedirect);
		rd.forward(request, response);
	}
}