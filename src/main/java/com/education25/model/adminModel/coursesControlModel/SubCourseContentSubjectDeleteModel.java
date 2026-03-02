package com.education25.model.adminModel.coursesControlModel;

public class SubCourseContentSubjectDeleteModel {
	private int admin_id;
	private String course_name;
	private String course_id;
	private String sub_course_name;
	private String sub_course_short_id;
	private String message_error;
	
	public SubCourseContentSubjectDeleteModel(int admin_id, String course_name, String course_id,
			String sub_course_name, String sub_course_short_id, String message_error) {
		super();
		this.admin_id = admin_id;
		this.course_name = course_name;
		this.course_id = course_id;
		this.sub_course_name = sub_course_name;
		this.sub_course_short_id = sub_course_short_id;
		this.message_error = message_error;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
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