package com.education25.model.adminModel.coursesControlModel;

public class SubHeadingContentModel {
	
	private String subHeadingName;
    private String definition;
    private String example;
	
    public SubHeadingContentModel(String subHeadingName, String definition, String example) {
		super();
		this.subHeadingName = subHeadingName;
		this.definition = definition;
		this.example = example;
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