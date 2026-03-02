package com.education25.service.adminService.coursesControlService;

import com.education25.dao.adminDao.coursesControlDao.SubCourseContentAddOneSubHeadingDaoImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentAddOneSubHeadingFormModel;
import com.education25.validation.checkValues.CheckStringLengthUnder5500;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceUnwantedCharecters;

public class SubCourseContentAddOneSubHeadingServiceImpl implements SubCourseContentAddOneSubHeadingService {

	@Override
	public String addOneSubHeadingService(SubCourseContentAddOneSubHeadingFormModel subHeadingFormModel) {
		subHeadingFormModel = CheckValidationService(subHeadingFormModel);
		if(subHeadingFormModel.getMessage_error()!=null) {
			return subHeadingFormModel.getMessage_error();
		}else {
			return new SubCourseContentAddOneSubHeadingDaoImpl().addOneSubHeadingDao(subHeadingFormModel);
		}
	}

	@Override
	public SubCourseContentAddOneSubHeadingFormModel CheckValidationService(SubCourseContentAddOneSubHeadingFormModel subHeadingFormModel) {
		String message_error=null, sub_course_text =null, sub_heading_definition=null, sub_heading_example=null;
		
		sub_course_text=subHeadingFormModel.getSub_heading_text();
		sub_heading_definition = subHeadingFormModel.getSub_heading_definition();
		sub_heading_example = subHeadingFormModel.getSub_heading_example();
		
		ReplaceUnwantedCharecters replaceUnwantedCharecters = new ReplaceUnwantedCharecters();
		CheckStringLengthUnder5500 checkStringLengthUnder5500 = new CheckStringLengthUnder5500();
		
		if(subHeadingFormModel.getHeading_id()==null || subHeadingFormModel.getSub_heading_id()==null) {
			message_error="Try again because not find valid information";
		}else if(sub_course_text==null) {
			message_error="sub Heading text is empty, Fist fill sub heading then click update";
		}else {
			sub_course_text=sub_course_text.trim();
			sub_course_text=replaceUnwantedCharecters.replace(checkStringLengthUnder5500.length150(sub_course_text));
			subHeadingFormModel.setSub_heading_text(sub_course_text);
			
			if(sub_heading_definition!=null) {
				sub_heading_definition=sub_heading_definition.trim();
				sub_heading_definition = replaceUnwantedCharecters.replace(checkStringLengthUnder5500.length5500(sub_heading_definition));
				subHeadingFormModel.setSub_heading_definition(sub_heading_definition);
			}
			if(sub_heading_example!=null) {
				sub_heading_example=sub_heading_example.trim();
				sub_heading_example = replaceUnwantedCharecters.replace(checkStringLengthUnder5500.length5500(sub_heading_example));
				subHeadingFormModel.setSub_heading_example(sub_heading_example);
			}
		}
		if(message_error!=null) {
			subHeadingFormModel.setMessage_error(message_error);
		}
		return subHeadingFormModel;
	}
}