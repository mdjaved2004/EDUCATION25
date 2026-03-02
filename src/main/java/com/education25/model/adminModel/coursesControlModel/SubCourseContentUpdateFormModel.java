package com.education25.model.adminModel.coursesControlModel;

public class SubCourseContentUpdateFormModel {
	private int adminId;
	private int courseId;
	private String courseName;
	private String subCourseName;
	
	public SubCourseContentUpdateFormModel(int adminId, int courseId, String courseName, String subCourseName) {
		super();
		this.adminId = adminId;
		this.courseId = courseId;
		this.courseName = courseName;
		this.subCourseName = subCourseName;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getSubCourseName() {
		return subCourseName;
	}

	public void setSubCourseName(String subCourseName) {
		this.subCourseName = subCourseName;
	}
}