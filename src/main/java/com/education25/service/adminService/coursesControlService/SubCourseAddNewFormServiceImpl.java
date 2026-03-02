package com.education25.service.adminService.coursesControlService;

import com.education25.dao.adminDao.coursesControlDao.AddNewSubcourseFormDaoImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseAddNewFormModel;
import com.education25.validation.checkValues.ChechAZ_az_09_spaceAndFirstcharIsAlphabet;
import com.education25.validation.checkValues.CheckStringIsInteger;

public class SubCourseAddNewFormServiceImpl implements SubCourseAddNewFormService {

	@Override
	public String addNewSubcourseFormService(SubCourseAddNewFormModel addNewSubcourseFormModel) {
		String checkInformation=null;
		
		checkInformation = checkInformation(addNewSubcourseFormModel);
		
		if(checkInformation!=null) {
			return checkInformation;
		}
		
		checkInformation = new AddNewSubcourseFormDaoImpl().checkSubcourseAvailableOrNot(addNewSubcourseFormModel.getSub_course_name(), addNewSubcourseFormModel.getCourse_id());
		
		return checkInformation;
	}
	
	
	@Override
	public String checkInformation(SubCourseAddNewFormModel addNewSubcourseFormModel) {
		String subject_name=null, message_error=null;
		boolean checkString=false;
		
		subject_name = addNewSubcourseFormModel.getSub_course_name();
		
		ChechAZ_az_09_spaceAndFirstcharIsAlphabet chechAZ_az_09AndFirstcharIsAlphabet = new ChechAZ_az_09_spaceAndFirstcharIsAlphabet();
		
		checkString = chechAZ_az_09AndFirstcharIsAlphabet.chechAZ_az_09_spaceAndFirstcharIsAlphabetBollean(subject_name);
		if(!checkString) {
			message_error="Subject name, Only charecter allow A to Z, a to z, space and digit 0 to 9";
		}else if(subject_name.length() >= 35) {
			message_error = "Subject name must be less than 35 characters.";
		}
					
		boolean checkStringIsInteger = new CheckStringIsInteger().checkStringIsInteger(addNewSubcourseFormModel.getPrice());
		if(!checkStringIsInteger) {
			message_error = "Price only number allow";
		}
		return message_error;
	}
}
