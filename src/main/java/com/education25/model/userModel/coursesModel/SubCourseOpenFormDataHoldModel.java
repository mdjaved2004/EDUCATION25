package com.education25.model.userModel.coursesModel;

public class SubCourseOpenFormDataHoldModel {
	private String course_name;
	private String course_id;
	private String sub_course_name;
	private String sub_course_sort_id;
	private String price;
	
	public SubCourseOpenFormDataHoldModel(String course_name, String course_id, String sub_course_name,
			String sub_course_sort_id, String price) {
		super();
		this.course_name = course_name;
		this.course_id = course_id;
		this.sub_course_name = sub_course_name;
		this.sub_course_sort_id = sub_course_sort_id;
		this.price = price;
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

	public String getSub_course_sort_id() {
		return sub_course_sort_id;
	}

	public void setSub_course_sort_id(String sub_course_sort_id) {
		this.sub_course_sort_id = sub_course_sort_id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}