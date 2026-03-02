package com.education25.model.adminModel.coursesControlModel;

public class SubCourseIdWithMessageErrorModel {
	private int sub_course_id;
	private String message_error;
	private String new_image_link;
	
	public SubCourseIdWithMessageErrorModel(int sub_course_id, String message_error, String new_image_link) {
		super();
		this.sub_course_id = sub_course_id;
		this.message_error = message_error;
		this.new_image_link = new_image_link;
	}

	public int getSub_course_id() {
		return sub_course_id;
	}

	public void setSub_course_id(int sub_course_id) {
		this.sub_course_id = sub_course_id;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}

	public String getNew_image_link() {
		return new_image_link;
	}

	public void setNew_image_link(String new_image_link) {
		this.new_image_link = new_image_link;
	}
}