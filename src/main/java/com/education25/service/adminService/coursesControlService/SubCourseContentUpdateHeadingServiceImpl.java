package com.education25.service.adminService.coursesControlService;

import com.education25.dao.adminDao.coursesControlDao.SubCourseContentUpdateHeadingDaoImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseHeadingUpdateModel;
import com.education25.validation.checkValues.CheckStringLengthUnder5500;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceUnwantedCharecters;

public class SubCourseContentUpdateHeadingServiceImpl implements SubCourseContentUpdateHeadingService {

	@Override
	public String updateHeadingService(SubCourseHeadingUpdateModel subCourseHeadingUpdateModel) {	
		subCourseHeadingUpdateModel = checkValidation(subCourseHeadingUpdateModel);
		if(subCourseHeadingUpdateModel.getMessage_error()!=null) {
			return subCourseHeadingUpdateModel.getMessage_error();
		}else {
			return new SubCourseContentUpdateHeadingDaoImpl().updateHeadingDao(subCourseHeadingUpdateModel);		
		}
	}

	@Override
	public SubCourseHeadingUpdateModel checkValidation(SubCourseHeadingUpdateModel subCourseHeadingUpdateModel) {
		String message_error=null, heading_text=null;
		
		heading_text= subCourseHeadingUpdateModel.getHeading_text();
		ReplaceUnwantedCharecters replaceUnwantedCharecters = new ReplaceUnwantedCharecters();
		CheckStringLengthUnder5500 checkStringLengthUnder5500 = new CheckStringLengthUnder5500();
		
		if(heading_text!=null) {
			heading_text=heading_text.trim();
			heading_text=replaceUnwantedCharecters.replace(checkStringLengthUnder5500.length150(heading_text));
			subCourseHeadingUpdateModel.setHeading_text(heading_text);
			
		}else {
			message_error="Heading text is empty, Fist fill heading then click update";
		}
		
		if(message_error!=null) {
			subCourseHeadingUpdateModel.setMessage_error(message_error);
		}
		return subCourseHeadingUpdateModel;
	}
}