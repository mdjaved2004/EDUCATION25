package com.education25.model.adminModel.paperControlModel;

import java.util.List;

public class QuestionPaperUpdateFormDataGetModel {
	private List<String> paperNameList;
	private String message_error;
	
	public QuestionPaperUpdateFormDataGetModel(List<String> paperNameList, String message_error) {
		super();
		this.paperNameList = paperNameList;
		this.message_error = message_error;
	}

	public List<String> getPaperNameList() {
		return paperNameList;
	}

	public void setPaperNameList(List<String> paperNameList) {
		this.paperNameList = paperNameList;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}
}