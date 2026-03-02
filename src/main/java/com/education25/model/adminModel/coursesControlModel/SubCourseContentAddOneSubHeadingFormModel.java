package com.education25.model.adminModel.coursesControlModel;

public class SubCourseContentAddOneSubHeadingFormModel {
	
	private String heading_id;
	private String sub_heading_id;
	private String sub_course_name;
	private String sub_course_short_id;
	private String sub_heading_text;
	private String sub_heading_definition;
	private String sub_heading_example;
	private String message_error;
	
	public SubCourseContentAddOneSubHeadingFormModel(String heading_id, String sub_heading_id, String sub_course_name,
			String sub_course_short_id, String sub_heading_text, String sub_heading_definition,
			String sub_heading_example, String message_error) {
		super();
		this.heading_id = heading_id;
		this.sub_heading_id = sub_heading_id;
		this.sub_course_name = sub_course_name;
		this.sub_course_short_id = sub_course_short_id;
		this.sub_heading_text = sub_heading_text;
		this.sub_heading_definition = sub_heading_definition;
		this.sub_heading_example = sub_heading_example;
		this.message_error = message_error;
	}

	public String getHeading_id() {
		return heading_id;
	}

	public void setHeading_id(String heading_id) {
		this.heading_id = heading_id;
	}

	public String getSub_heading_id() {
		return sub_heading_id;
	}

	public void setSub_heading_id(String sub_heading_id) {
		this.sub_heading_id = sub_heading_id;
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

	public String getSub_heading_text() {
		return sub_heading_text;
	}

	public void setSub_heading_text(String sub_heading_text) {
		this.sub_heading_text = sub_heading_text;
	}

	public String getSub_heading_definition() {
		return sub_heading_definition;
	}

	public void setSub_heading_definition(String sub_heading_definition) {
		this.sub_heading_definition = sub_heading_definition;
	}

	public String getSub_heading_example() {
		return sub_heading_example;
	}

	public void setSub_heading_example(String sub_heading_example) {
		this.sub_heading_example = sub_heading_example;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}
}