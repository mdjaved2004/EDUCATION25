package com.education25.model.adminModel.coursesControlModel;

import java.util.List;

public class SubCourseFullInformationModel {
	
	private List<SubCourseHeadingModel> subCourseHeading;
	private List<SubCourseSubHeadingModel> subCourseSubHeading;
	private String message_error;
	
	public SubCourseFullInformationModel(List<SubCourseHeadingModel> subCourseHeading,
			List<SubCourseSubHeadingModel> subCourseSubHeading, String message_error) {
		super();
		this.subCourseHeading = subCourseHeading;
		this.subCourseSubHeading = subCourseSubHeading;
		this.message_error = message_error;
	}

	public List<SubCourseHeadingModel> getSubCourseHeading() {
		return subCourseHeading;
	}

	public void setSubCourseHeading(List<SubCourseHeadingModel> subCourseHeading) {
		this.subCourseHeading = subCourseHeading;
	}

	public List<SubCourseSubHeadingModel> getSubCourseSubHeading() {
		return subCourseSubHeading;
	}

	public void setSubCourseSubHeading(List<SubCourseSubHeadingModel> subCourseSubHeading) {
		this.subCourseSubHeading = subCourseSubHeading;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}
}