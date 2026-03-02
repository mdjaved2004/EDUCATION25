package com.education25.model.adminModel.coursesControlModel;

public class SubCourseContentAddOneHeadingFormModel {
	
	private String heading_id;
	private String heading_name;
	private String sub_course_name;
	private String sub_course_short_id;
	private String message_error;
	
	public SubCourseContentAddOneHeadingFormModel(String heading_id, String heading_name, String sub_course_name,
			String sub_course_short_id, String message_error) {
		super();
		this.heading_id = heading_id;
		this.heading_name = heading_name;
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

	public String getHeading_name() {
		return heading_name;
	}

	public void setHeading_name(String heading_name) {
		this.heading_name = heading_name;
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