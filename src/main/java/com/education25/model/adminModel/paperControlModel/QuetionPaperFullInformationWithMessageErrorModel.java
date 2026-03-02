package com.education25.model.adminModel.paperControlModel;

import java.util.List;

public class QuetionPaperFullInformationWithMessageErrorModel {
	private QuestionPaperInformationModel paperInformation;
	private List<QuetionPaperQuetionInformationGetModel> questionInfoList;
	private String message_error;
	 
	public QuetionPaperFullInformationWithMessageErrorModel(QuestionPaperInformationModel paperInformation,
			List<QuetionPaperQuetionInformationGetModel> questionInfoList, String message_error) {
		super();
		this.paperInformation = paperInformation;
		this.questionInfoList = questionInfoList;
		this.message_error = message_error;
	}

	public QuestionPaperInformationModel getPaperInformation() {
		return paperInformation;
	}

	public void setPaperInformation(QuestionPaperInformationModel paperInformation) {
		this.paperInformation = paperInformation;
	}

	public List<QuetionPaperQuetionInformationGetModel> getQuestionInfoList() {
		return questionInfoList;
	}

	public void setQuestionInfoList(List<QuetionPaperQuetionInformationGetModel> questionInfoList) {
		this.questionInfoList = questionInfoList;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}
}