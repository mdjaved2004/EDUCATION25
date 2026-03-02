package com.education25.model.userModel.onlineExamAndCertificateModel;

public class GetCertificateModel {
	private String subject;
	private String marks_persentage;
	
	public GetCertificateModel(String subject, String marks_persentage) {
		super();
		this.subject = subject;
		this.marks_persentage = marks_persentage;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMarks_persentage() {
		return marks_persentage;
	}

	public void setMarks_persentage(String marks_persentage) {
		this.marks_persentage = marks_persentage;
	}
}