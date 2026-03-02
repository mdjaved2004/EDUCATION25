package com.education25.model.userModel.coursesModel;

import java.util.List;

public class SubCourseInformationGetModel {
	private List<SubCourseHeadingContentGetModel> subCourseHeading;
	private List<SubCourseSubHeadingContentGetModel> subCourseSubHeading;
	private List<SubCourseRelativeCourseInformationGetModel> subCourseRelative;
	private String message_error;
	
	public SubCourseInformationGetModel(List<SubCourseHeadingContentGetModel> subCourseHeading,
			List<SubCourseSubHeadingContentGetModel> subCourseSubHeading,
			List<SubCourseRelativeCourseInformationGetModel> subCourseRelative, String message_error) {
		super();
		this.subCourseHeading = subCourseHeading;
		this.subCourseSubHeading = subCourseSubHeading;
		this.subCourseRelative = subCourseRelative;
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

	public List<SubCourseRelativeCourseInformationGetModel> getSubCourseRelative() {
		return subCourseRelative;
	}

	public void setSubCourseRelative(List<SubCourseRelativeCourseInformationGetModel> subCourseRelative) {
		this.subCourseRelative = subCourseRelative;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}
}