package com.education25.model.adminModel.paperControlModel;

public class QuestionPaperQuestionDataWithmessageErrorModel {
	private QuestionPaperQuestionDataModel quetionInformation;
	private String message_error;
	
	public QuestionPaperQuestionDataWithmessageErrorModel(QuestionPaperQuestionDataModel quetionInformation,
			String message_error) {
		super();
		this.quetionInformation = quetionInformation;
		this.message_error = message_error;
	}

	public QuestionPaperQuestionDataModel getQuetionInformation() {
		return quetionInformation;
	}

	public void setQuetionInformation(QuestionPaperQuestionDataModel quetionInformation) {
		this.quetionInformation = quetionInformation;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}
}