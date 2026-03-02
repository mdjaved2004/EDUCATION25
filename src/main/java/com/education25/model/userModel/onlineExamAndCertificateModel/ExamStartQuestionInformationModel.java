package com.education25.model.userModel.onlineExamAndCertificateModel;

public class ExamStartQuestionInformationModel {
	private int ques_id;
	private String question;
	private String option_A;
	private String option_B;
	private String option_C;
	private String option_D;
	private String optionMarks;
	private String notOptionMarks;
	
	public ExamStartQuestionInformationModel(int ques_id, String question, String option_A, String option_B,
			String option_C, String option_D, String optionMarks, String notOptionMarks) {
		super();
		this.ques_id = ques_id;
		this.question = question;
		this.option_A = option_A;
		this.option_B = option_B;
		this.option_C = option_C;
		this.option_D = option_D;
		this.optionMarks = optionMarks;
		this.notOptionMarks = notOptionMarks;
	}

	public int getQues_id() {
		return ques_id;
	}

	public void setQues_id(int ques_id) {
		this.ques_id = ques_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption_A() {
		return option_A;
	}

	public void setOption_A(String option_A) {
		this.option_A = option_A;
	}

	public String getOption_B() {
		return option_B;
	}

	public void setOption_B(String option_B) {
		this.option_B = option_B;
	}

	public String getOption_C() {
		return option_C;
	}

	public void setOption_C(String option_C) {
		this.option_C = option_C;
	}

	public String getOption_D() {
		return option_D;
	}

	public void setOption_D(String option_D) {
		this.option_D = option_D;
	}

	public String getOptionMarks() {
		return optionMarks;
	}

	public void setOptionMarks(String optionMarks) {
		this.optionMarks = optionMarks;
	}

	public String getNotOptionMarks() {
		return notOptionMarks;
	}

	public void setNotOptionMarks(String notOptionMarks) {
		this.notOptionMarks = notOptionMarks;
	}		
}