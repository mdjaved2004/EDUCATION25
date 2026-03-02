package com.education25.model.ServletContextModel;

public class SubCourseInformationModel {

	private int sub_course_id;
    private String sub_course_name;
    private String image_link;
    private int price;
    private int sort_id;
    private int learning_days;
	
    public SubCourseInformationModel(int sub_course_id, String sub_course_name, String image_link, int price,
			int sort_id, int learning_days) {
		super();
		this.sub_course_id = sub_course_id;
		this.sub_course_name = sub_course_name;
		this.image_link = image_link;
		this.price = price;
		this.sort_id = sort_id;
		this.learning_days = learning_days;
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

	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSort_id() {
		return sort_id;
	}

	public void setSort_id(int sort_id) {
		this.sort_id = sort_id;
	}

	public int getLearning_days() {
		return learning_days;
	}

	public void setLearning_days(int learning_days) {
		this.learning_days = learning_days;
	}
}