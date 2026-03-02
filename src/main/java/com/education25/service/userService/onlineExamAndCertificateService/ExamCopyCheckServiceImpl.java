package com.education25.service.userService.onlineExamAndCertificateService;

import com.education25.dao.userDao.onlineExamAndCertificateDao.ExamCopyCheckDaoImpl;
import com.education25.model.userModel.commonModel.MessageAndErrormessageModel;
import com.education25.model.userModel.onlineExamAndCertificateModel.ExamStartPaperInformation;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_;

public class ExamCopyCheckServiceImpl implements ExamCopyCheckService {

	@Override
	public MessageAndErrormessageModel copyCkeckAndStoreDataServive(int user_resister_id, String[] resultStore, ExamStartPaperInformation paperInforStore) {
		//set paperName Without space
		paperInforStore.setPaper_Name(removeSpace(paperInforStore.getPaper_Name()));
		
		return new ExamCopyCheckDaoImpl().copyCkeckAndStoreDataDao(user_resister_id, resultStore, paperInforStore);
	}

	@Override
	public String removeSpace(String value) {
		return new ReplaceSpaceTo_().replaceSpaceTo_(value);
	}
}