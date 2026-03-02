package com.education25.service.adminService.coursesControlService;

import com.education25.dao.adminDao.coursesControlDao.SubCourseContentAddImageDao;
import com.education25.dao.adminDao.coursesControlDao.SubCourseContentAddImageDaoImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseImageUpdateModel;
import com.education25.model.adminModel.coursesControlModel.SubCourseIdWithMessageErrorModel;

public class SubCourseContentAddImageServiceImpl implements SubCourseContentAddImageService {

	@Override
	public SubCourseIdWithMessageErrorModel updateImageService(SubCourseImageUpdateModel model) {
		String message_error =null;
		message_error = validationCheckService(model);
		
		if(message_error!=null) {
			return new SubCourseIdWithMessageErrorModel(0, message_error, null);
		}	
		
		SubCourseContentAddImageDao imageUpdateDao= new SubCourseContentAddImageDaoImpl();
		
		return imageUpdateDao.updateImageService(model);
	}
	
	public String  validationCheckService(SubCourseImageUpdateModel model) {
		String message_error = null;
		
		if(model.getCourse_name().trim() == null || model.getSub_course_short_id().trim()==null) {
			message_error ="Invalid information, Try Again";
		}else if(model.getImage_input().getSubmittedFileName().trim()== null){
			message_error ="Image Information Is currupt, Try Again";
		}						
		return message_error;		
	}

}