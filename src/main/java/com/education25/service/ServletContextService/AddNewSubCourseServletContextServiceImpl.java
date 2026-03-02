package com.education25.service.ServletContextService;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.education25.model.ServletContextModel.CoursesInformationGetModel;
import com.education25.model.ServletContextModel.SubCourseInformationModel;

public class AddNewSubCourseServletContextServiceImpl implements AddNewSubCourseServletContextService {

	@Override
	public boolean addNewSubCourse(HttpServletRequest request, CoursesInformationGetModel course,
			SubCourseInformationModel subcourse) {
		Map<CoursesInformationGetModel, List<SubCourseInformationModel>> coursesAndSubCoursesInfo=null;
		List<CoursesInformationGetModel> coursesInformation=null;
		CoursesInformationGetModel	targetCourseKey = null;
		boolean result =false; 
		
		if (course == null|| subcourse == null) {
	        return false;
	    }else {		
			ServletContext ctx = request.getServletContext();
			coursesAndSubCoursesInfo =(Map<CoursesInformationGetModel, List<SubCourseInformationModel>>) ctx.getAttribute("coursesAndSubCoursesMap");
			coursesInformation =(List<CoursesInformationGetModel>) ctx.getAttribute("coursesList");
			
			// Add new SubCourse and update key CoursesInformationGetModel,
			for (CoursesInformationGetModel c : coursesAndSubCoursesInfo.keySet()) {
			    if (c.getCourse_id() == course.getCourse_id()) {
		    			c.setNoOfSubCourses(course.getNoOfSubCourses());
		    			targetCourseKey = c ;
			        break;
			    	 }
			}
			if (targetCourseKey != null) {
			    List<SubCourseInformationModel> subList = coursesAndSubCoursesInfo.get(targetCourseKey);	
			    subList.add(subcourse);
			    
			    // increase count in Map key object
	            targetCourseKey.setNoOfSubCourses(targetCourseKey.getNoOfSubCourses() + 1);
			}
			
			//update value in course.
			for (CoursesInformationGetModel c : coursesInformation) {
			    if (c.getCourse_id() == course.getCourse_id()) {
			        c.setNoOfSubCourses(course.getNoOfSubCourses());
			        break;
			    }
			}			
			return result;
	    }
	}
}