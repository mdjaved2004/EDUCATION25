package com.education25.model.adminModel.coursesControlModel;

import java.util.List;

public class SubCoursesContentListAndMessageModel {
     private String message_error;
     private List<SubCoursesAndCourseContentModel> SubCoursesInfo;
	 
     public SubCoursesContentListAndMessageModel(String message_error,
			List<SubCoursesAndCourseContentModel> subCoursesInfo) {
		super();
		this.message_error = message_error;
		SubCoursesInfo = subCoursesInfo;
	 }

	 public String getMessage_error() {
		 return message_error;
	 }

	 public void setMessage_error(String message_error) {
		 this.message_error = message_error;
	 }

	 public List<SubCoursesAndCourseContentModel> getSubCoursesInfo() {
		 return SubCoursesInfo;
	 }

	 public void setSubCoursesInfo(List<SubCoursesAndCourseContentModel> subCoursesInfo) {
		 SubCoursesInfo = subCoursesInfo;
	 }
}