package com.education25.model.userModel.coursesModel;

import java.util.List;

public class BuyCoursesTextDataModel {
	private List<SubCourseHeadingContentGetModel> subCourseHeading;
	private List<SubCourseSubHeadingContentGetModel> subCourseSubHeading;
	private String message_error;
	
	public BuyCoursesTextDataModel(List<SubCourseHeadingContentGetModel> subCourseHeading,
			List<SubCourseSubHeadingContentGetModel> subCourseSubHeading, String message_error) {
		super();
		this.subCourseHeading = subCourseHeading;
		this.subCourseSubHeading = subCourseSubHeading;
		this.message_error = message_error;
	}

	public List<SubCourseHeadingContentGetModel> getSubCourseHeading() {
		return subCourseHeading;
	}

	public void setSubCourseHeading(List<SubCourseHeadingContentGetModel> subCourseHeading) {
		this.subCourseHeading = subCourseHeading;
	}

	public List<SubCourseSubHeadingContentGetModel> getSubCourseSubHeading() {
		return subCourseSubHeading;
	}

	public void setSubCourseSubHeading(List<SubCourseSubHeadingContentGetModel> subCourseSubHeading) {
		this.subCourseSubHeading = subCourseSubHeading;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}
}
