package com.education25.service.adminService.coursesControlService;

import com.education25.dao.adminDao.coursesControlDao.SubCourseContentUpdateSubHeadingDaoImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseSubHeadingUpdateModel;
import com.education25.validation.checkValues.CheckStringLengthUnder5500;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceUnwantedCharecters;

public class SubCourseContentUpdateSubHeadingServiceImpl implements SubCourseContentUpdateSubHeadingService {
	@Override
	public String updateSubHeadingService(SubCourseSubHeadingUpdateModel subCourseSubHeadingUpdateModel) {	
		subCourseSubHeadingUpdateModel = checkValidation(subCourseSubHeadingUpdateModel);
		if(subCourseSubHeadingUpdateModel.getMessage_error()!=null) {
			return subCourseSubHeadingUpdateModel.getMessage_error();
		}else {	
			return new SubCourseContentUpdateSubHeadingDaoImpl().updateSubHeadingDao(subCourseSubHeadingUpdateModel);
		}
	}

	@Override
	public SubCourseSubHeadingUpdateModel checkValidation(SubCourseSubHeadingUpdateModel subCourseSubHeadingUpdateModel) {
		String message_error=null, sub_course_text =null, sub_heading_definition=null, sub_heading_example=null;
		
		sub_course_text=subCourseSubHeadingUpdateModel.getSub_heading_text();
		sub_heading_definition = subCourseSubHeadingUpdateModel.getSub_heading_definition();
		sub_heading_example = subCourseSubHeadingUpdateModel.getSub_heading_example();
		
		ReplaceUnwantedCharecters replaceUnwantedCharecters = new ReplaceUnwantedCharecters();
		CheckStringLengthUnder5500 checkStringLengthUnder5500 = new CheckStringLengthUnder5500();
		
		if(subCourseSubHeadingUpdateModel.getHeading_id()==null || subCourseSubHeadingUpdateModel.getSub_heading_id()==null) {
			message_error="Try again because not find valid information";
		}else if(sub_course_text==null) {
			message_error="sub Heading text is empty, Fist fill sub heading then click update";
		}else {
			sub_course_text=sub_course_text.trim();
			sub_course_text=replaceUnwantedCharecters.replace(checkStringLengthUnder5500.length150(sub_course_text));
			subCourseSubHeadingUpdateModel.setSub_heading_text(sub_course_text);
			
			if(sub_heading_definition!=null) {
				sub_heading_definition=sub_heading_definition.trim();
				sub_heading_definition = replaceUnwantedCharecters.replace(checkStringLengthUnder5500.length5500(sub_heading_definition));
				subCourseSubHeadingUpdateModel.setSub_heading_definition(sub_heading_definition);
			}
			if(sub_heading_example!=null) {
				sub_heading_example=sub_heading_example.trim();
				sub_heading_example = replaceUnwantedCharecters.replace(checkStringLengthUnder5500.length5500(sub_heading_example));
				subCourseSubHeadingUpdateModel.setSub_heading_example(sub_heading_example);
			}
		}
		if(message_error!=null) {
			subCourseSubHeadingUpdateModel.setMessage_error(message_error);
		}
		return subCourseSubHeadingUpdateModel;
	}
}