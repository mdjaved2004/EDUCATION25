package com.education25.service.userService.onlineExamAndCertificateService;

import com.education25.model.userModel.onlineExamAndCertificateModel.ExamStartModel;

public interface ExamStartService {
	ExamStartModel getExamStartContext(String paperName, int paperId);
	String spaceRemoveService(String value);
}