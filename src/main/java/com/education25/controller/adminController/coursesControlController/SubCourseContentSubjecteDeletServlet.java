package com.education25.controller.adminController.coursesControlController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentSubjectDeleteModel;
import com.education25.service.ServletContextService.DeleteOneSubCourseServletContextServiceImpl;
import com.education25.service.adminService.authService.AdminVerifyServiceImpl;
import com.education25.service.adminService.coursesControlService.SubCourseContentSubjectDeleteService;
import com.education25.service.adminService.coursesControlService.SubCourseContentSubjectDeleteServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-subject-deleted")
public class SubCourseContentSubjecteDeletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String course_name=null, course_id_string=null, sub_course_name=null, sub_course_short_id=null, message_error=null, message=null;
		int adminId=0, course_id=0;
		
		//Verify  this person are admin are not admin  and return true or false.
		HttpSession session = request.getSession();
		adminId=new AdminVerifyServiceImpl().adminVerifyAdminPosition(session);	
		
		if(adminId==0) {
			request.setAttribute("message_error", "You are not login, Please login first");
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/login.jsp");
			rd.forward(request, response);
			return;
		}
		
		course_name = request.getParameter("course_name");
		course_id_string = request.getParameter("course_id");
		sub_course_name = request.getParameter("sub_course_name");
		sub_course_short_id = request.getParameter("sub_course_short_id");
		
		if(course_name==null || course_id_string==null || sub_course_name==null || sub_course_short_id==null) {
			request.setAttribute("message_error", "Try again because not find valid information");
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/control-courses.jsp");
			rd.forward(request, response);
			return;
		}
		
		//Hold value in model class
		SubCourseContentSubjectDeleteModel model= new SubCourseContentSubjectDeleteModel(adminId, course_name, course_id_string, sub_course_name, sub_course_short_id, message_error);
		
		SubCourseContentSubjectDeleteService service=new SubCourseContentSubjectDeleteServiceImpl();
		
		message_error = service.subCourseDeleteService(model);
		
		if(message_error==null) {
			int sub_course_short_id_int = Integer.parseInt(sub_course_short_id);
			course_id = Integer.parseInt(course_id_string);
			new DeleteOneSubCourseServletContextServiceImpl().deleteOneSubCourse(request, course_id, sub_course_short_id_int);
			message = "Subject "+sub_course_name+" succesfull deleted.";	
			request.setAttribute("message", message);
		}else {
			request.setAttribute("message_error", message_error);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/control-courses.jsp");
		rd.forward(request, response);
		return;
	}
}