package com.education25.model.adminModel.coursesControlModel;

public class SubCourseImageGetInformationModel {
	private String image_link;
	private String price;
	private String learning_days;
	
	public SubCourseImageGetInformationModel(String image_link, String price, String learning_days) {
		super();
		this.image_link = image_link;
		this.price = price;
		this.learning_days = learning_days;
	}

	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLearning_days() {
		return learning_days;
	}

	public void setLearning_days(String learning_days) {
		this.learning_days = learning_days;
	}	
}