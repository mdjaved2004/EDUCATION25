package com.education25.model.adminModel.coursesControlModel;

import com.education25.model.ServletContextModel.CoursesInformationGetModel;
import com.education25.model.ServletContextModel.SubCourseInformationModel;

public class CourseAndSubCourseWithMessageInfoModel {
	private CoursesInformationGetModel course;
	private SubCourseInformationModel subcourse;
	private String message_error;
	
	public CourseAndSubCourseWithMessageInfoModel(CoursesInformationGetModel course,
			SubCourseInformationModel subcourse, String message_error) {
		super();
		this.course = course;
		this.subcourse = subcourse;
		this.message_error = message_error;
	}

	public CoursesInformationGetModel getCourse() {
		return course;
	}

	public void setCourse(CoursesInformationGetModel course) {
		this.course = course;
	}

	public SubCourseInformationModel getSubcourse() {
		return subcourse;
	}

	public void setSubcourse(SubCourseInformationModel subcourse) {
		this.subcourse = subcourse;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}	
}