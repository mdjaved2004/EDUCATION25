package com.education25.controller.adminController.coursesControlController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.education25.model.adminModel.coursesControlModel.SubCourseIdWithMessageErrorModel;
import com.education25.model.adminModel.coursesControlModel.SubCourseImageUpdateModel;
import com.education25.service.ServletContextService.SubCourseImageLinkUpdateServletContextServiceImpl;
import com.education25.service.adminService.authService.AdminVerifyServiceImpl;
import com.education25.service.adminService.coursesControlService.SubCourseContentAddImageService;
import com.education25.service.adminService.coursesControlService.SubCourseContentAddImageServiceImpl;
import java.io.IOException;

@WebServlet("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-image-update")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2,   // 1 MB (memory threshold)
    maxFileSize = 1024 * 1024 * 2,          // 1 MB (single file max)
    maxRequestSize = 1024 * 1024 * 2  + 1024       // 1 MB + 1kb (total request size)
)
public class SubCourseContentAddImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	String id =null, course_name=null, course_id=null, sub_course_name=null, sub_course_short_id=null, old_image_link =null, message_error=null, pageRedirect=null;	
		int AdminId=0;
		Part image_input =null;
		
		HttpSession session = request.getSession();
		
		AdminId=new AdminVerifyServiceImpl().adminVerifyAdminPosition(session);
		if(AdminId==0) {
			request.setAttribute("message_error", "You are not login, Please login first");
	    	 	RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/login.jsp");
			rd.forward(request, response);
			return;
		}
	  
		id=request.getParameter("id");
		course_name= request.getParameter("course_name");
		course_id= request.getParameter("course_id");
		sub_course_name= request.getParameter("sub_course_name");
		sub_course_short_id= request.getParameter("sub_course_short_id");
		old_image_link = request.getParameter("image_link");
		
		image_input = request.getPart("image_input");
		
		request.setAttribute("id", id);
		request.setAttribute("course_name", course_name);
		request.setAttribute("course_id", course_id);
		request.setAttribute("sub_course_name", sub_course_name);
		request.setAttribute("sub_course_short_id", sub_course_short_id);
		
		if(id==null || course_name==null || course_id==null || sub_course_name==null || sub_course_short_id==null || image_input == null) {
			message_error ="Wrong activity , Try Again";
			request.setAttribute("image_link", old_image_link);
			request.setAttribute("messgae_error", message_error);
			
			pageRedirect = "/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-add-image.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(pageRedirect);
			rd.forward(request, response);
			return;
		}

		//Hold value in Model class.
		SubCourseImageUpdateModel model = new SubCourseImageUpdateModel(course_name, sub_course_short_id, old_image_link, image_input , AdminId);
		
		SubCourseContentAddImageService imageUpdateService = new SubCourseContentAddImageServiceImpl();
		
		SubCourseIdWithMessageErrorModel updateImageService = imageUpdateService.updateImageService(model);
		
		if(updateImageService.getMessage_error()!=null) {
			request.setAttribute("image_link", old_image_link);
			request.setAttribute("messgae_error", updateImageService.getMessage_error());
			pageRedirect = "/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-add-image.jsp";
		}else {
			new SubCourseImageLinkUpdateServletContextServiceImpl().updateLink(request, Integer.parseInt(course_id), updateImageService.getSub_course_id(), updateImageService.getNew_image_link());
			pageRedirect = "/viewPages/admin-view-pages/control-courses-view-pages/sub-course-update-image-view";
			request.setAttribute("message", "Succesfull update Image");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(pageRedirect);
		rd.forward(request, response);
		return;    
   }
}