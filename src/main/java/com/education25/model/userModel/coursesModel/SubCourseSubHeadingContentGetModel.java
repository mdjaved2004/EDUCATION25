package com.education25.model.userModel.coursesModel;

public class SubCourseSubHeadingContentGetModel {
	private int headingId;
	private int subHeadingId;
	private String subHeadingName;
    private String definition;
    private String example;
	
    public SubCourseSubHeadingContentGetModel(int headingId, int subHeadingId, String subHeadingName, String definition,
			String example) {
		super();
		this.headingId = headingId;
		this.subHeadingId = subHeadingId;
		this.subHeadingName = subHeadingName;
		this.definition = definition;
		this.example = example;
	}

	public int getHeadingId() {
		return headingId;
	}

	public void setHeadingId(int headingId) {
		this.headingId = headingId;
	}

	public int getSubHeadingId() {
		return subHeadingId;
	}

	public void setSubHeadingId(int subHeadingId) {
		this.subHeadingId = subHeadingId;
	}

	public String getSubHeadingName() {
		return subHeadingName;
	}

	public void setSubHeadingName(String subHeadingName) {
		this.subHeadingName = subHeadingName;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}
}