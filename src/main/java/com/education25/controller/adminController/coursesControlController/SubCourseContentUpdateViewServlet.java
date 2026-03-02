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
import com.education25.model.adminModel.coursesControlModel.SubCourseMainContentModel;
import com.education25.model.ServletContextModel.CoursesInformationGetModel;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentUpdateFormModel;
import com.education25.service.adminService.authService.AdminVerifyServiceImpl;
import com.education25.service.adminService.coursesControlService.CousesVerifyServiceImpl;
import com.education25.service.adminService.coursesControlService.SubCourseContentUpdateViewService;
import com.education25.service.adminService.coursesControlService.SubCourseContentUpdateViewServiceImpl;

@WebServlet("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-view")
public class SubCourseContentUpdateViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		ServletContext context = getServletContext();	
    		String courseName=null,subCourseName=null, formId=null, pageRedirect=null;
    		int adminId=0, courseId=0;
    		
		//Verify  this person are admin are not admin  and return true or false.
		HttpSession session = request.getSession();
		adminId=new AdminVerifyServiceImpl().adminVerifyAdminPosition(session);	
		
		if(adminId==0) {
			request.setAttribute("message_error", "You are not login, Please login first");
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/login.jsp");
			rd.forward(request, response);
			return;
		}
    	
    		//Get Data.
		formId=request.getParameter("id");
		courseName = request.getParameter("course_name");
        subCourseName = request.getParameter("sub_course_name");

        if(courseName!=null)courseName=courseName.trim();
        if(subCourseName!=null)subCourseName=subCourseName.trim();
        
        if(courseName==null || subCourseName==null) {
        		request.setAttribute("message_error", "Input box empty, Please fill information");
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-form.jsp");
			rd.forward(request, response);
			return;
        }
    		
         courseId = new CousesVerifyServiceImpl().courseId((List<CoursesInformationGetModel>) context.getAttribute("coursesList"), courseName);
     
    		//Hold data in model class
        SubCourseContentUpdateFormModel subCourseContentFormModel = new SubCourseContentUpdateFormModel(adminId, courseId, courseName, subCourseName);
       
        SubCourseContentUpdateViewService service = new SubCourseContentUpdateViewServiceImpl();
    	
        SubCourseMainContentModel checkCourseAndSubCourseModel = service.checkCourseAndSubCourseServoice(subCourseContentFormModel);
        
        if(checkCourseAndSubCourseModel.getMessage_error()!=null) {
        		request.setAttribute("message_error", checkCourseAndSubCourseModel.getMessage_error());
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/control-courses.jsp");
			rd.forward(request, response);
			return;
        }else {
        		request.setAttribute("id", formId);
        		request.setAttribute("course_name", courseName);
        
        		request.setAttribute("course_id", Integer.toString(checkCourseAndSubCourseModel.getCourseId()));
        		request.setAttribute("sub_course_name", checkCourseAndSubCourseModel.getSubCourseName());
        		request.setAttribute("sub_course_short_id", Integer.toString(checkCourseAndSubCourseModel.getSortId()));
        		
        		switch (formId) {
	            case "update":
//	            case "upload_video":
	                pageRedirect = "/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-data";
	                break;
	                
	            case "deleteCourse":
	            		pageRedirect = "/viewPages/admin-view-pages/control-courses-view-pages/sub-course-delete-view";
	            		break;
	            		
	            case "addImage":
            			pageRedirect = "/viewPages/admin-view-pages/control-courses-view-pages/sub-course-update-image-view";
            			break;
	            	
	            default:
            			request.setAttribute("message_error", "Not find this page, Please try again");
	                pageRedirect = "/viewPages/admin-view-pages/control-courses-view-pages/control-courses.jsp";
		    	}
        }
		RequestDispatcher rd = request.getRequestDispatcher(pageRedirect);
		rd.forward(request, response);
		return;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("message")!=null) { 
			  request.setAttribute("message",  request.getParameter("message")); 
		 }else if(request.getParameter("message_error")!=null) { 
			  request.setAttribute("message_error",  request.getParameter("message")); 
		 }
		doPost(request, response);
	}
}