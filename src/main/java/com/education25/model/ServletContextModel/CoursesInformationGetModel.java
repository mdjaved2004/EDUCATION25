package com.education25.model.ServletContextModel;

public class CoursesInformationGetModel {
	
	private int course_id;
	private String course_name;
	private int noOfSubCourses;
	
	public CoursesInformationGetModel(int course_id, String course_name, int noOfSubCourses) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.noOfSubCourses = noOfSubCourses;
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

	public int getNoOfSubCourses() {
		return noOfSubCourses;
	}

	public void setNoOfSubCourses(int noOfSubCourses) {
		this.noOfSubCourses = noOfSubCourses;
	}
}