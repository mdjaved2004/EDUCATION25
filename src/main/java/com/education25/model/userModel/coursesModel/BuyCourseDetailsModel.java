package com.education25.model.userModel.coursesModel;

public class BuyCourseDetailsModel {
	private String courseName;
    private String courseId;
    private String subCourseId;
    private String subCourseName;
    private String learningDays;
    private String price;
    private String sortId;
    private String imageLink;
    private String message_error;
	
    public BuyCourseDetailsModel(String courseName, String courseId, String subCourseId, String subCourseName,
			String learningDays, String price, String sortId, String imageLink, String message_error) {
		super();
		this.courseName = courseName;
		this.courseId = courseId;
		this.subCourseId = subCourseId;
		this.subCourseName = subCourseName;
		this.learningDays = learningDays;
		this.price = price;
		this.sortId = sortId;
		this.imageLink = imageLink;
		this.message_error = message_error;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getSubCourseId() {
		return subCourseId;
	}

	public void setSubCourseId(String subCourseId) {
		this.subCourseId = subCourseId;
	}

	public String getSubCourseName() {
		return subCourseName;
	}

	public void setSubCourseName(String subCourseName) {
		this.subCourseName = subCourseName;
	}

	public String getLearningDays() {
		return learningDays;
	}

	public void setLearningDays(String learningDays) {
		this.learningDays = learningDays;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSortId() {
		return sortId;
	}

	public void setSortId(String sortId) {
		this.sortId = sortId;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getError_message() {
		return message_error;
	}

	public void setError_message(String message_error) {
		this.message_error = message_error;
	} 
}