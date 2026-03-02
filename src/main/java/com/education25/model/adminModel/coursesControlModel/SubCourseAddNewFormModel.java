package com.education25.model.adminModel.coursesControlModel;

public class SubCourseAddNewFormModel {	
	private int course_id;
	private String course_name;
	private String sub_course_name;
	private String learning_days;
	private String price;
	
	public SubCourseAddNewFormModel(int course_id, String course_name, String sub_course_name, String learning_days,
			String price) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.sub_course_name = sub_course_name;
		this.learning_days = learning_days;
		this.price = price;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getSub_course_name() {
		return sub_course_name;
	}

	public void setSub_course_name(String sub_course_name) {
		this.sub_course_name = sub_course_name;
	}

	public String getLearning_days() {
		return learning_days;
	}

	public void setLearning_days(String learning_days) {
		this.learning_days = learning_days;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}