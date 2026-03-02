package com.education25.model.adminModel.coursesControlModel;

public class SubCourseMainContentModel {
	private int subCourseId;
    private String subCourseName;
    private int sortId;
    private int courseId;
    private String message_error;
	
    public SubCourseMainContentModel(int subCourseId, String subCourseName, int sortId, int courseId,
			String message_error) {
		super();
		this.subCourseId = subCourseId;
		this.subCourseName = subCourseName;
		this.sortId = sortId;
		this.courseId = courseId;
		this.message_error = message_error;
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

	public int getSortId() {
		return sortId;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}  
}