package com.education25.model.userModel.coursesModel;

public class SubCourseAndSubCourseSortIdWithMessageModel {
	private String sub_course_name;
	private String sub_course_sort_id;
	private String message_error;
	
	public SubCourseAndSubCourseSortIdWithMessageModel(String sub_course_name, String sub_course_sort_id,
			String message_error) {
		super();
		this.sub_course_name = sub_course_name;
		this.sub_course_sort_id = sub_course_sort_id;
		this.message_error = message_error;
	}

	public String getSub_course_name() {
		return sub_course_name;
	}

	public void setSub_course_name(String sub_course_name) {
		this.sub_course_name = sub_course_name;
	}

	public String getSub_course_sort_id() {
		return sub_course_sort_id;
	}

	public void setSub_course_sort_id(String sub_course_sort_id) {
		this.sub_course_sort_id = sub_course_sort_id;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}
}