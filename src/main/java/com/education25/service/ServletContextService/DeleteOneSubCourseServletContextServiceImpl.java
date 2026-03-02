package com.education25.service.ServletContextService;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.education25.model.ServletContextModel.CoursesInformationGetModel;
import com.education25.model.ServletContextModel.SubCourseInformationModel;

public class DeleteOneSubCourseServletContextServiceImpl implements DeleteOneSubCourseServletContextService {
	
	@Override
	public boolean deleteOneSubCourse(HttpServletRequest request, int course_id, int subCourseShortId) {
	    if (course_id == 0 || subCourseShortId == 0) {
	        return false;
	    }

	    ServletContext ctx = request.getServletContext();

	    Map<CoursesInformationGetModel, List<SubCourseInformationModel>> coursesAndSubCoursesInfo =
	            (Map<CoursesInformationGetModel, List<SubCourseInformationModel>>) ctx.getAttribute("coursesAndSubCoursesMap");

	    List<CoursesInformationGetModel> coursesInformation =
	            (List<CoursesInformationGetModel>) ctx.getAttribute("coursesList");

	    CoursesInformationGetModel targetCourseKey = null;
	    boolean result = false;
	    
	    //Find Course Key
	    for (CoursesInformationGetModel c : coursesAndSubCoursesInfo.keySet()) {
	        if (c.getCourse_id() == course_id) {
	            targetCourseKey = c;
	            break;
	        }
	    }
	    
	    //Remove SubCourse using Iterator
	    if (targetCourseKey != null) {
	        List<SubCourseInformationModel> subList = coursesAndSubCoursesInfo.get(targetCourseKey);

	        if (subList != null) {
	            Iterator<SubCourseInformationModel> iterator = subList.iterator();
	            
	            while (iterator.hasNext()) {
	                SubCourseInformationModel sc = iterator.next();
	                if (sc.getSort_id() == subCourseShortId) {
	                    iterator.remove();   // safe remove
	                    result = true;

	                    // decrease count
	                    targetCourseKey.setNoOfSubCourses(targetCourseKey.getNoOfSubCourses() - 1);
	                    break;
	                }
	            }
	        }
	    }

	    //Update count in coursesInformation list
	    if (result) {
	        for (CoursesInformationGetModel c : coursesInformation) {
	            if (c.getCourse_id() == course_id) {
	                c.setNoOfSubCourses(c.getNoOfSubCourses() - 1);
	                break;
	            }
	        }
	    }

	    return result;
	}
}
