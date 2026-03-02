package com.education25.model.userModel.coursesModel;

public class SubCourseHeadingContentGetModel {
	private int headingId;
	private String headingName;
	
	public SubCourseHeadingContentGetModel(int headingId, String headingName) {
		super();
		this.headingId = headingId;
		this.headingName = headingName;
	}

	public int getHeadingId() {
		return headingId;
	}

	public void setHeadingId(int headingId) {
		this.headingId = headingId;
	}

	public String getHeadingName() {
		return headingName;
	}

	public void setHeadingName(String headingName) {
		this.headingName = headingName;
	}
}