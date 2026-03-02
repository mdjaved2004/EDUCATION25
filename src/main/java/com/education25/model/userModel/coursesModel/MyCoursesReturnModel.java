package com.education25.model.userModel.coursesModel;

import java.util.List;

public class MyCoursesReturnModel {
	
	private List<MyCoursesPaidSubCoursesModel> paidCourseList;
	private List<MyCoursesFreeSubCoursesModel> freeCourseList;
	private List<MyCoursesFreeSubCoursesModel> buyCoursesSuggestion;
	
	public MyCoursesReturnModel(List<MyCoursesPaidSubCoursesModel> paidCourseList,
			List<MyCoursesFreeSubCoursesModel> freeCourseList,
			List<MyCoursesFreeSubCoursesModel> buyCoursesSuggestion) {
		super();
		this.paidCourseList = paidCourseList;
		this.freeCourseList = freeCourseList;
		this.buyCoursesSuggestion = buyCoursesSuggestion;
	}

	public List<MyCoursesPaidSubCoursesModel> getPaidCourseList() {
		return paidCourseList;
	}

	public void setPaidCourseList(List<MyCoursesPaidSubCoursesModel> paidCourseList) {
		this.paidCourseList = paidCourseList;
	}

	public List<MyCoursesFreeSubCoursesModel> getFreeCourseList() {
		return freeCourseList;
	}

	public void setFreeCourseList(List<MyCoursesFreeSubCoursesModel> freeCourseList) {
		this.freeCourseList = freeCourseList;
	}

	public List<MyCoursesFreeSubCoursesModel> getBuyCoursesSuggestion() {
		return buyCoursesSuggestion;
	}

	public void setBuyCoursesSuggestion(List<MyCoursesFreeSubCoursesModel> buyCoursesSuggestion) {
		this.buyCoursesSuggestion = buyCoursesSuggestion;
	}
}