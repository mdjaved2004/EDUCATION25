package com.education25.service.adminService.coursesControlService;

import com.education25.model.adminModel.coursesControlModel.SubCourseAddNewFormModel;

public interface SubCourseAddNewFormService {
	String addNewSubcourseFormService(SubCourseAddNewFormModel addNewSubcourseFormModel);
    String checkInformation(SubCourseAddNewFormModel addNewSubcourseFormModel);
}