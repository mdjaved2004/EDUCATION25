package com.education25.model.userModel.coursesModel;

import java.util.List;

public class BuyCourseOpenInformationGetModel {
	private List<SubCourseHeadingContentGetModel> subCourseHeading;
	private List<SubCourseSubHeadingContentGetModel> subCourseSubHeading;
	private List<SubCourseRelativeCourseInformationGetModel> subCourseRelative;
	private String sub_course_name;
	private String message_error;
	
	public BuyCourseOpenInformationGetModel(List<SubCourseHeadingContentGetModel> subCourseHeading,
			List<SubCourseSubHeadingContentGetModel> subCourseSubHeading,
			List<SubCourseRelativeCourseInformationGetModel> subCourseRelative, String sub_course_name,
			String message_error) {
		super();
		this.subCourseHeading = subCourseHeading;
		this.subCourseSubHeading = subCourseSubHeading;
		this.subCourseRelative = subCourseRelative;
		this.sub_course_name = sub_course_name;
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

	public String getSub_course_name() {
		return sub_course_name;
	}

	public void setSub_course_name(String sub_course_name) {
		this.sub_course_name = sub_course_name;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}
}