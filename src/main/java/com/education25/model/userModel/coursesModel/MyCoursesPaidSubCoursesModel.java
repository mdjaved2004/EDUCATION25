package com.education25.model.userModel.coursesModel;

public class MyCoursesPaidSubCoursesModel {
	
	private int sub_course_Id;
	private String sub_cour_name;
	private String learning_days;
 	private int price;
 	private String sort_id;
 	private String image_link;
 	private String course_name;
 	private int course_id;
	
 	public MyCoursesPaidSubCoursesModel(int sub_course_Id, String sub_cour_name, String learning_days, int price,
			String sort_id, String image_link, String course_name, int course_id) {
		super();
		this.sub_course_Id = sub_course_Id;
		this.sub_cour_name = sub_cour_name;
		this.learning_days = learning_days;
		this.price = price;
		this.sort_id = sort_id;
		this.image_link = image_link;
		this.course_name = course_name;
		this.course_id = course_id;
	}

	public int getSub_course_Id() {
		return sub_course_Id;
	}

	public void setSub_course_Id(int sub_course_Id) {
		this.sub_course_Id = sub_course_Id;
	}

	public String getSub_cour_name() {
		return sub_cour_name;
	}

	public void setSub_cour_name(String sub_cour_name) {
		this.sub_cour_name = sub_cour_name;
	}

	public String getLearning_days() {
		return learning_days;
	}

	public void setLearning_days(String learning_days) {
		this.learning_days = learning_days;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSort_id() {
		return sort_id;
	}

	public void setSort_id(String sort_id) {
		this.sort_id = sort_id;
	}

	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
}