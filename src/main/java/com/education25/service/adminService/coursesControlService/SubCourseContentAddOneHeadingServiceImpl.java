package com.education25.service.adminService.coursesControlService;

import com.education25.dao.adminDao.coursesControlDao.SubCourseContentAddOneHeadingDaoImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentAddOneHeadingFormModel;
import com.education25.validation.checkValues.CheckStringLengthUnder5500;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceUnwantedCharecters;

public class SubCourseContentAddOneHeadingServiceImpl implements SubCourseContentAddOneHeadingService {

	@Override
	public String addOneHeadingService(SubCourseContentAddOneHeadingFormModel modelFormData) {
		modelFormData = CheckValidationService(modelFormData);
		if(modelFormData.getMessage_error()!=null) {
			return modelFormData.getMessage_error();
		}else {
			return new SubCourseContentAddOneHeadingDaoImpl().addOneHeadingDao(modelFormData);
		}
	}

	@Override
	public SubCourseContentAddOneHeadingFormModel CheckValidationService(	SubCourseContentAddOneHeadingFormModel modelFormData) {
		String heading_name =null , message_error=null;
		
		heading_name= modelFormData.getHeading_name();
		ReplaceUnwantedCharecters replaceUnwantedCharecters = new ReplaceUnwantedCharecters();
		CheckStringLengthUnder5500 checkStringLengthUnder5500 = new CheckStringLengthUnder5500();
		
		if(heading_name!=null) {
			heading_name=heading_name.trim();
			heading_name=replaceUnwantedCharecters.replace(checkStringLengthUnder5500.length150(heading_name));
			modelFormData.setHeading_name(heading_name);
			
		}else {
			message_error="Heading text is empty, Fist fill heading then click update";
		}
		
		if(message_error!=null) {
			modelFormData.setMessage_error(message_error);
		}
		return modelFormData;
	}
}