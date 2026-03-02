package com.education25.model.adminModel.paperControlModel;

public class PaperInformationForImageUpdateModel {
	
	private int paper_id;
	private String paper_name;
	private int total_ques;
	private String image_link;
	private String message_error;
	
	public PaperInformationForImageUpdateModel(int paper_id, String paper_name, int total_ques, String image_link,
			String message_error) {
		super();
		this.paper_id = paper_id;
		this.paper_name = paper_name;
		this.total_ques = total_ques;
		this.image_link = image_link;
		this.message_error = message_error;
	}

	public int getPaper_id() {
		return paper_id;
	}

	public void setPaper_id(int paper_id) {
		this.paper_id = paper_id;
	}

	public String getPaper_name() {
		return paper_name;
	}

	public void setPaper_name(String paper_name) {
		this.paper_name = paper_name;
	}

	public int getTotal_ques() {
		return total_ques;
	}

	public void setTotal_ques(int total_ques) {
		this.total_ques = total_ques;
	}

	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}	
}