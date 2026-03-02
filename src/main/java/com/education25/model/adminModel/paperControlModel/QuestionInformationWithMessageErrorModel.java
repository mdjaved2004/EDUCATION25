package com.education25.model.adminModel.paperControlModel;

import java.util.List;

public class QuestionInformationWithMessageErrorModel {
	
	private List<QuestionPaperQuestionDataModel> questionDataStrore;
	private String message_error;
	
	public QuestionInformationWithMessageErrorModel(List<QuestionPaperQuestionDataModel> questionDataStrore,
			String message_error) {
		super();
		this.questionDataStrore = questionDataStrore;
		this.message_error = message_error;
	}

	public List<QuestionPaperQuestionDataModel> getQuestionDataStrore() {
		return questionDataStrore;
	}

	public void setQuestionDataStrore(List<QuestionPaperQuestionDataModel> questionDataStrore) {
		this.questionDataStrore = questionDataStrore;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}
}