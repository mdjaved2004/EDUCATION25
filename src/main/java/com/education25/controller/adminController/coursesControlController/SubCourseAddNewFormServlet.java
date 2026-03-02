package com.education25.controller.adminController.coursesControlController;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.model.ServletContextModel.CoursesInformationGetModel;
import com.education25.model.adminModel.coursesControlModel.SubCourseAddNewFormModel;
import com.education25.service.adminService.authService.AdminVerifyServiceImpl;
import com.education25.service.adminService.coursesControlService.CousesVerifyServiceImpl;
import com.education25.service.adminService.coursesControlService.SubCourseAddNewFormService;
import com.education25.service.adminService.coursesControlService.SubCourseAddNewFormServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-add-new-form")
public class SubCourseAddNewFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String course_name=null, sub_course_name=null, learning_days=null, price=null, message_error=null;
		int course_id =0;
		boolean verifyAdmin=false;
		
		HttpSession session = request.getSession();
		
		//verify this person are admin are not admin  and return true or false.
		verifyAdmin=new AdminVerifyServiceImpl().adminVerifyBoolean(session);
		if(!verifyAdmin) {
			request.setAttribute("message_error", "You are not login, Please login first");
	    	 	RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/login.jsp");
			rd.forward(request, response);
			return;
		}
				
		course_name = request.getParameter("course_name");
		sub_course_name =request.getParameter("sub_course_name");
		learning_days=request.getParameter("learning_days");
		price=request.getParameter("price");
		
		if(course_name!=null)course_name=course_name.trim();
		if(sub_course_name!=null)sub_course_name=sub_course_name.trim();
		if(learning_days!=null)learning_days=learning_days.trim();
		if(price!=null)price=price.trim();
			
		if(course_name==null) message_error="Course Name not allow to null, Please fill course name";
		else if(sub_course_name==null) message_error="Subject Name not allow to null, Please fill subject name";
		else if(learning_days==null) message_error="Learning days not allow to null, Please enter learning days";
		else if(price==null) message_error="Price not allow to null, Please enter price";
		else message_error=null;
		
		if(message_error!=null) {
			request.setAttribute("message_error", message_error);
	    	 	RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-add-new-form.jsp");
			rd.forward(request, response);
			return;
		}
		
		//verifyCourse and if course match then return course id in String form.
		course_id = new CousesVerifyServiceImpl().courseId((List<CoursesInformationGetModel>) context.getAttribute("coursesList"), course_name);
		
		if(course_id==0) {
			request.setAttribute("message_error", "Course Name not allow to null, Please fill course name");
	    	 	RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-add-new-form.jsp");
			rd.forward(request, response);
			return;
		}
		
		//Hold all input value in model class.
		SubCourseAddNewFormModel addNewSubcourseFormModel = new SubCourseAddNewFormModel(course_id, course_name, sub_course_name, learning_days, price);
				
		SubCourseAddNewFormService addNewSubcourseFormService = new	SubCourseAddNewFormServiceImpl();
		
		String checkInformation = addNewSubcourseFormService.addNewSubcourseFormService(addNewSubcourseFormModel);
	
		if(checkInformation==null) {
			request.setAttribute("course_name",course_name);
			request.setAttribute("course_id",course_id);
			request.setAttribute("sub_course_name",sub_course_name);
			request.setAttribute("learning_days",learning_days);
			request.setAttribute("price",price);
			request.setAttribute("message_error", message_error);
	    	 	RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-insert.jsp");
			rd.forward(request, response);
			return;
		}else {
			request.setAttribute("message_error", checkInformation);
	    	 	RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-add-new-form.jsp");
			rd.forward(request, response);
			return;
		}
	}
}