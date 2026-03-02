package com.education25.model.userModel.onlineExamAndCertificateModel;

import java.util.List;

public class ExamStartModel {
	
	private ExamStartPaperInformation paperInfo;	
	private List<ExamStartQuestionInformationModel> listOfQuestionInfo;
	
	public ExamStartModel(ExamStartPaperInformation paperInfo,
			List<ExamStartQuestionInformationModel> listOfQuestionInfo) {
		super();
		this.paperInfo = paperInfo;
		this.listOfQuestionInfo = listOfQuestionInfo;
	}

	public ExamStartPaperInformation getPaperInfo() {
		return paperInfo;
	}

	public void setPaperInfo(ExamStartPaperInformation paperInfo) {
		this.paperInfo = paperInfo;
	}

	public List<ExamStartQuestionInformationModel> getListOfQuestionInfo() {
		return listOfQuestionInfo;
	}

	public void setListOfQuestionInfo(List<ExamStartQuestionInformationModel> listOfQuestionInfo) {
		this.listOfQuestionInfo = listOfQuestionInfo;
	}	
}