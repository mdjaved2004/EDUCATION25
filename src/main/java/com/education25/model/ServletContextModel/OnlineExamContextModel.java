package com.education25.model.ServletContextModel;

public class OnlineExamContextModel {
	
	private int paper_id;
	private String paper_Name;
	private int total_ques;
	private int option_ques;
	private int notOption_ques;
	private String image_link;
	
	public OnlineExamContextModel(int paper_id, String paper_Name, int total_ques, int option_ques, int notOption_ques,
			String image_link) {
		super();
		this.paper_id = paper_id;
		this.paper_Name = paper_Name;
		this.total_ques = total_ques;
		this.option_ques = option_ques;
		this.notOption_ques = notOption_ques;
		this.image_link = image_link;
	}

	public int getPaper_id() {
		return paper_id;
	}

	public void setPaper_id(int paper_id) {
		this.paper_id = paper_id;
	}

	public String getPaper_Name() {
		return paper_Name;
	}

	public void setPaper_Name(String paper_Name) {
		this.paper_Name = paper_Name;
	}

	public int getTotal_ques() {
		return total_ques;
	}

	public void setTotal_ques(int total_ques) {
		this.total_ques = total_ques;
	}

	public int getOption_ques() {
		return option_ques;
	}

	public void setOption_ques(int option_ques) {
		this.option_ques = option_ques;
	}

	public int getNotOption_ques() {
		return notOption_ques;
	}

	public void setNotOption_ques(int notOption_ques) {
		this.notOption_ques = notOption_ques;
	}

	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}
}