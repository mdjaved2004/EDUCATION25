package com.education25.dao.userDao.onlineExamAndCertificateDao;

import com.education25.model.userModel.commonModel.MessageAndErrormessageModel;
import com.education25.model.userModel.onlineExamAndCertificateModel.ExamStartPaperInformation;

public interface ExamCopyCheckDao {
	MessageAndErrormessageModel copyCkeckAndStoreDataDao(int user_resister_id, String resultStore[],ExamStartPaperInformation paperInforStore);
}