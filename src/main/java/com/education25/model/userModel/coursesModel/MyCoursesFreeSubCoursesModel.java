package com.education25.model.userModel.coursesModel;

public class MyCoursesFreeSubCoursesModel {
	 	
	private int sub_course_id;
    private String sub_course_name;
    private String learning_days;
    private int price;
    private String sort_id;
    private String image_link;
    
    private int course_id;
    private String course_name;
	
    public MyCoursesFreeSubCoursesModel(int sub_course_id, String sub_course_name, String learning_days, int price,
			String sort_id, String image_link, int course_id, String course_name) {
		super();
		this.sub_course_id = sub_course_id;
		this.sub_course_name = sub_course_name;
		this.learning_days = learning_days;
		this.price = price;
		this.sort_id = sort_id;
		this.image_link = image_link;
		this.course_id = course_id;
		this.course_name = course_name;
	}

	public int getSub_course_id() {
		return sub_course_id;
	}

	public void setSub_course_id(int sub_course_id) {
		this.sub_course_id = sub_course_id;
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
}