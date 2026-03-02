package com.education25.model.adminModel.paperControlModel;

public class QuestionPaperInformationModel {
	private String paper_name;
    private String total_ques;
    private String option_ques;
    private String notOption_ques;
	
    public QuestionPaperInformationModel(String paper_name, String total_ques, String option_ques,
			String notOption_ques) {
		super();
		this.paper_name = paper_name;
		this.total_ques = total_ques;
		this.option_ques = option_ques;
		this.notOption_ques = notOption_ques;
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

	public String getOption_ques() {
		return option_ques;
	}

	public void setOption_ques(String option_ques) {
		this.option_ques = option_ques;
	}

	public String getNotOption_ques() {
		return notOption_ques;
	}

	public void setNotOption_ques(String notOption_ques) {
		this.notOption_ques = notOption_ques;
	}
}