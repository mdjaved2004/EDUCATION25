package com.education25.model.userModel.coursesModel;

public class SubCourseNameWithMessageModel {
	private String sub_course_name;
	private String message_error;
	
	public SubCourseNameWithMessageModel(String sub_course_name, String message_error) {
		super();
		this.sub_course_name = sub_course_name;
		this.message_error = message_error;
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