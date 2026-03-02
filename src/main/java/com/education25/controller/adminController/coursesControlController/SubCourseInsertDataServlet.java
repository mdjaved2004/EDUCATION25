package com.education25.controller.adminController.coursesControlController;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.model.ServletContextModel.CoursesInformationGetModel;
import com.education25.model.adminModel.coursesControlModel.CourseAndSubCourseWithMessageInfoModel;
import com.education25.model.adminModel.coursesControlModel.SubCourseAddNewFormModel;
import com.education25.model.adminModel.coursesControlModel.SubHeadingContentModel;
import com.education25.service.ServletContextService.AddNewSubCourseServletContextServiceImpl;
import com.education25.service.adminService.authService.AdminVerifyServiceImpl;
import com.education25.service.adminService.coursesControlService.CousesVerifyServiceImpl;
import com.education25.service.adminService.coursesControlService.SubCourseInsertDataService;
import com.education25.service.adminService.coursesControlService.SubCourseInsertDataServiceImpl;
import com.education25.validation.checkValues.CheckStringLengthUnder5500;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceUnwantedCharecters;

@WebServlet("/viewPages/admin-view-pages/control-courses-view-pages/sub-cources_insert_data")
public class SubCourseInsertDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	String course_id_string=null,course_name=null, sub_course_name=null, learning_days=null, price=null, message=null, message_error=null;
	    	int adminId=0, course_id=0;
	    	CourseAndSubCourseWithMessageInfoModel courseAndSubCourseWithMessageInfo =null;
	    	
        try {
			  
			//Verify  this person are admin are not admin  and return true or false.
			HttpSession session = request.getSession();
			adminId=new AdminVerifyServiceImpl().adminVerifyAdminPosition(session);	
			
			if(adminId==0) {
				request.setAttribute("message_error", "You are not login, Please login first");
				RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/login.jsp");
				rd.forward(request, response);
				return;
			}
			
			// Get data for request.
			course_id_string = request.getParameter("course_id");
			course_name = request.getParameter("course_name");
			sub_course_name = request.getParameter("sub_course_name");
			learning_days = request.getParameter("learning_days");
			price = request.getParameter("price");

			//Replace space to _
			sub_course_name= new ReplaceSpaceTo_().replaceSpaceTo_(sub_course_name);
			
			if(course_name==null) message_error="Course Name not found, Please try again";
			else if(sub_course_name==null) message_error="Subject Name not found, Please try again";
			else if(learning_days==null) message_error="Learning days not found, Please try again";
			else if(price==null) message_error="Price not found, Please try again";
			else message_error=null;
			
			if(course_id_string!=null) {
				course_id =Integer.parseInt(course_id_string);
			}else {
				message_error ="Course Information is not find";
			}
			//VerifyCourse and if course not match then return null value.
			ServletContext context = getServletContext();
			message_error = new CousesVerifyServiceImpl().checkCourseNameAndCourseId((List<CoursesInformationGetModel>) context.getAttribute("coursesList"), course_name, course_id);
				     
			if(message_error!=null){
				request.setAttribute("message_error", " This course Name Not Found, Please try agin to select right course name");
				RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/control-courses-view-pages/sub-course-add-new-form.jsp");
				rd.forward(request, response);
				return;
			}
			
			//Hold all input value in model class.
			SubCourseAddNewFormModel subcourseFormModel = new SubCourseAddNewFormModel(course_id, course_name, sub_course_name, learning_days, price);
			
			Map<String, List<SubHeadingContentModel>> subCourseContent = new LinkedHashMap<>();
			
			CheckStringLengthUnder5500 checkStringLengthUnder5500 = new CheckStringLengthUnder5500();
			ReplaceUnwantedCharecters replaceUnwantedCharecters = new ReplaceUnwantedCharecters();
			
			int heading_count = 1;
			while (request.getParameter("heading" + heading_count) != null &&
			        !request.getParameter("heading" + heading_count).trim().isEmpty()) {
				
				String heading = request.getParameter("heading" + heading_count);
				heading=heading.trim();
				heading = replaceUnwantedCharecters.replace(heading);
				heading =checkStringLengthUnder5500.length150(heading);
			    
				//List for this heading
				    List<SubHeadingContentModel> subHeadingList = new ArrayList<>();
      
				    int subHeading_count = 0;

				    while (request.getParameter("sub-heading" + heading_count + (char)('a' + subHeading_count)) != null &&
			            !request.getParameter("sub-heading" + heading_count + (char)('a' + subHeading_count)).trim().isEmpty()) {
				    	
				    		String sub_Id = heading_count + String.valueOf((char)('a' + subHeading_count));
				    		String subHeadingName = request.getParameter("sub-heading" + sub_Id);
				    		String definition = request.getParameter("definition" + sub_Id);
				    		String example = request.getParameter("example" + sub_Id);
				    		
				    		subHeadingName=subHeadingName.trim();
				    		subHeadingName = replaceUnwantedCharecters.replace(subHeadingName);
				    		subHeadingName = checkStringLengthUnder5500.length150(subHeadingName);
				    		
				    		if(definition!=null) {
				    			definition = replaceUnwantedCharecters.replace(definition);
				    			definition = checkStringLengthUnder5500.length5500(definition);
				    			if(definition != null) {
				    				definition = definition.trim();
				    		    }
				    		}
				    		if(example!=null) {
				    			example = replaceUnwantedCharecters.replace(example);
				    			example = checkStringLengthUnder5500.length5500(example);	
				    			if(example != null) {
				    		        example = example.trim();
				    		    }
				    		}
				    					         
				    		// Create model object
				    		SubHeadingContentModel model = new SubHeadingContentModel(subHeadingName, definition, example);
			         
				    		// Add to list
				    		subHeadingList.add(model);

				    		subHeading_count++;
				    }
				    // Put heading + its sub-heading list into map
				    subCourseContent.put(heading, subHeadingList);

				    heading_count++;
			 
			}
			// Service layer to process for insert data.
			SubCourseInsertDataService subCourseInsertDataService = new SubCourseInsertDataServiceImpl();	
			
			courseAndSubCourseWithMessageInfo = subCourseInsertDataService.subCourseInsertDataService(adminId, subcourseFormModel, subCourseContent);
		
        } catch (Exception e) {
			e.printStackTrace();
			message_error="Server error, Please try again";
			
		}
       
        if(courseAndSubCourseWithMessageInfo.getMessage_error()!=null) {
	        	response.sendRedirect(request.getContextPath() + "/viewPages/admin-view-pages/control-courses-view-pages/control-courses.jsp?message_error=" + URLEncoder.encode(message_error, "UTF-8"));
	        	return;
        }else {
        		
        		// Update ServletContent 
        		new AddNewSubCourseServletContextServiceImpl().addNewSubCourse(request, courseAndSubCourseWithMessageInfo.getCourse(), courseAndSubCourseWithMessageInfo.getSubcourse());

        		message="Sub-course created successfully!";
        		response.sendRedirect(request.getContextPath() + "/viewPages/admin-view-pages/control-courses-view-pages/control-courses.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	        	return;
        }				
    }
}
