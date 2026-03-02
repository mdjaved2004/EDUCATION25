package com.education25.model.adminModel.coursesControlModel;

public class SubCourseContentRemoveOneHeadingModel {
	private String heading_id;
	private String sub_course_name;
	private String sub_course_short_id;
	private String message_error;
	
	public SubCourseContentRemoveOneHeadingModel(String heading_id, String sub_course_name, String sub_course_short_id,
			String message_error) {
		super();
		this.heading_id = heading_id;
		this.sub_course_name = sub_course_name;
		this.sub_course_short_id = sub_course_short_id;
		this.message_error = message_error;
	}

	public String getHeading_id() {
		return heading_id;
	}

	public void setHeading_id(String heading_id) {
		this.heading_id = heading_id;
	}

	public String getSub_course_name() {
		return sub_course_name;
	}

	public void setSub_course_name(String sub_course_name) {
		this.sub_course_name = sub_course_name;
	}

	public String getSub_course_short_id() {
		return sub_course_short_id;
	}

	public void setSub_course_short_id(String sub_course_short_id) {
		this.sub_course_short_id = sub_course_short_id;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}
}