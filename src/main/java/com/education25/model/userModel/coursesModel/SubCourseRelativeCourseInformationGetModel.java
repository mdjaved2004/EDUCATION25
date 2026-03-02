package com.education25.model.userModel.coursesModel;

public class SubCourseRelativeCourseInformationGetModel {
	private String sub_course_sort_id;
    private String sub_course_name;
	
    public SubCourseRelativeCourseInformationGetModel(String sub_course_sort_id, String sub_course_name) {
		super();
		this.sub_course_sort_id = sub_course_sort_id;
		this.sub_course_name = sub_course_name;
	}

	public String getSub_course_sort_id() {
		return sub_course_sort_id;
	}

	public void setSub_course_sort_id(String sub_course_sort_id) {
		this.sub_course_sort_id = sub_course_sort_id;
	}

	public String getSub_course_name() {
		return sub_course_name;
	}

	public void setSub_course_name(String sub_course_name) {
		this.sub_course_name = sub_course_name;
	}
}