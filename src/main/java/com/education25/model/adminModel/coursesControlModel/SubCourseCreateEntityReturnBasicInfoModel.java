package com.education25.model.adminModel.coursesControlModel;

public class SubCourseCreateEntityReturnBasicInfoModel{

	private String sub_course_heading_table_name;
	private String sub_course_sub_heading_table_name;
	private String message_error;
	private int sub_course_id;
	
	public SubCourseCreateEntityReturnBasicInfoModel(String sub_course_heading_table_name,
			String sub_course_sub_heading_table_name, String message_error, int sub_course_id) {
		super();
		this.sub_course_heading_table_name = sub_course_heading_table_name;
		this.sub_course_sub_heading_table_name = sub_course_sub_heading_table_name;
		this.message_error = message_error;
		this.sub_course_id = sub_course_id;
	}

	public String getSub_course_heading_table_name() {
		return sub_course_heading_table_name;
	}

	public void setSub_course_heading_table_name(String sub_course_heading_table_name) {
		this.sub_course_heading_table_name = sub_course_heading_table_name;
	}

	public String getSub_course_sub_heading_table_name() {
		return sub_course_sub_heading_table_name;
	}

	public void setSub_course_sub_heading_table_name(String sub_course_sub_heading_table_name) {
		this.sub_course_sub_heading_table_name = sub_course_sub_heading_table_name;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}

	public int getSub_course_id() {
		return sub_course_id;
	}

	public void setSub_course_id(int sub_course_id) {
		this.sub_course_id = sub_course_id;
	}	
}