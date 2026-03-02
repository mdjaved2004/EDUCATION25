package com.education25.service.ServletContextService;

import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.education25.model.ServletContextModel.CoursesInformationGetModel;
import com.education25.model.ServletContextModel.SubCourseInformationModel;

public class SubCourseImageLinkUpdateServletContextServiceImpl implements SubCourseImageLinkUpdateServletContextService {

	@Override
	public boolean updateLink(HttpServletRequest request, int course_id, int Sub_course_id, String image_link) {
		Map<CoursesInformationGetModel, List<SubCourseInformationModel>> coursesAndSubCoursesInfo=null;
		CoursesInformationGetModel targetCourseKey =null;
		if(course_id!=0 && Sub_course_id!=0 && image_link!=null) {
			ServletContext ctx = request.getServletContext();
			coursesAndSubCoursesInfo = (Map<CoursesInformationGetModel, List<SubCourseInformationModel>>) ctx.getAttribute("coursesAndSubCoursesMap");
			for (CoursesInformationGetModel c : coursesAndSubCoursesInfo.keySet()) {
			    if (c.getCourse_id() == course_id) {
		    			targetCourseKey = c ;
			        break;
			    	 }
			}
			if (targetCourseKey != null) {
			    List<SubCourseInformationModel> subList = coursesAndSubCoursesInfo.get(targetCourseKey);	
			    for(SubCourseInformationModel subCourseModel : subList) {
			    		if(subCourseModel.getSub_course_id() == Sub_course_id) {
			    			//Set New Image Link.
			    			subCourseModel.setImage_link(image_link);
			    		}
			    }
			}
			
			return true;
		}else {
			return false;
		}
	}
}