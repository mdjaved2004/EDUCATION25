package com.education25.model.adminModel.paperControlModel;

public class QuestionPaperTempletCheckModel {
	
	private String paper_name;
    private String total_ques;
    private String select_que;
    private String select_marks;
    private String notSelect_que;
    private String notSelect_marks;
    private String total_marks;
    private String message_error;
	
    public QuestionPaperTempletCheckModel(String paper_name, String total_ques, String select_que, String select_marks,
			String notSelect_que, String notSelect_marks, String total_marks, String message_error) {
		super();
		this.paper_name = paper_name;
		this.total_ques = total_ques;
		this.select_que = select_que;
		this.select_marks = select_marks;
		this.notSelect_que = notSelect_que;
		this.notSelect_marks = notSelect_marks;
		this.total_marks = total_marks;
		this.message_error = message_error;
	}

	public String getPaper_name() {
		return paper_name;
	}

	public void setPaper_name(String paper_name) {
		this.paper_name = paper_name;
	}

	public String getTotal_ques() {
		return total_ques;
	}

	public void setTotal_ques(String total_ques) {
		this.total_ques = total_ques;
	}

	public String getSelect_que() {
		return select_que;
	}

	public void setSelect_que(String select_que) {
		this.select_que = select_que;
	}

	public String getSelect_marks() {
		return select_marks;
	}

	public void setSelect_marks(String select_marks) {
		this.select_marks = select_marks;
	}

	public String getNotSelect_que() {
		return notSelect_que;
	}

	public void setNotSelect_que(String notSelect_que) {
		this.notSelect_que = notSelect_que;
	}

	public String getNotSelect_marks() {
		return notSelect_marks;
	}

	public void setNotSelect_marks(String notSelect_marks) {
		this.notSelect_marks = notSelect_marks;
	}

	public String getTotal_marks() {
		return total_marks;
	}

	public void setTotal_marks(String total_marks) {
		this.total_marks = total_marks;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}
}