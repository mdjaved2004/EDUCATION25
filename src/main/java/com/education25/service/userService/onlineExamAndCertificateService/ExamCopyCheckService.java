package com.education25.service.userService.onlineExamAndCertificateService;

import com.education25.model.userModel.commonModel.MessageAndErrormessageModel;
import com.education25.model.userModel.onlineExamAndCertificateModel.ExamStartPaperInformation;

public interface ExamCopyCheckService {
	MessageAndErrormessageModel copyCkeckAndStoreDataServive(int user_resister_id, String resultStore[],ExamStartPaperInformation paperInforStore);
	String removeSpace(String value);
}