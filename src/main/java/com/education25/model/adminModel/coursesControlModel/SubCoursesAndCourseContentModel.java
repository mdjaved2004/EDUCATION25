package com.education25.model.adminModel.coursesControlModel;

public class SubCoursesAndCourseContentModel {
	private int subCourseId;
	private String subCourseName;
	private int learningDays;
	private int price;
	private int courseId;
	private int sortId;
	private int adminId;
	private String imageLink;
	private int imageAddAdminId;
	
	public SubCoursesAndCourseContentModel(int subCourseId, String subCourseName, int learningDays, int price,
			int courseId, int sortId, int adminId, String imageLink, int imageAddAdminId) {
		super();
		this.subCourseId = subCourseId;
		this.subCourseName = subCourseName;
		this.learningDays = learningDays;
		this.price = price;
		this.courseId = courseId;
		this.sortId = sortId;
		this.adminId = adminId;
		this.imageLink = imageLink;
		this.imageAddAdminId = imageAddAdminId;
	}

	public int getSubCourseId() {
		return subCourseId;
	}

	public void setSubCourseId(int subCourseId) {
		this.subCourseId = subCourseId;
	}

	public String getSubCourseName() {
		return subCourseName;
	}

	public void setSubCourseName(String subCourseName) {
		this.subCourseName = subCourseName;
	}

	public int getLearningDays() {
		return learningDays;
	}

	public void setLearningDays(int learningDays) {
		this.learningDays = learningDays;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getSortId() {
		return sortId;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public int getImageAddAdminId() {
		return imageAddAdminId;
	}

	public void setImageAddAdminId(int imageAddAdminId) {
		this.imageAddAdminId = imageAddAdminId;
	}
}