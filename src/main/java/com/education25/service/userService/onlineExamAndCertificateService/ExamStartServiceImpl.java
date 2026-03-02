package com.education25.service.userService.onlineExamAndCertificateService;

import com.education25.dao.userDao.onlineExamAndCertificateDao.ExamStartDaoImpl;
import com.education25.model.userModel.onlineExamAndCertificateModel.ExamStartModel;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_;

public class ExamStartServiceImpl implements ExamStartService {

	@Override
	public ExamStartModel getExamStartContext(String paperName, int paperId) {
		paperName =spaceRemoveService(paperName);
		
		ExamStartModel examStartContentDao = new ExamStartDaoImpl().getExamStartContextDao(paperName, paperId);
		
		return examStartContentDao;
	}

	@Override
	public String spaceRemoveService(String value) {
		return new ReplaceSpaceTo_().replaceSpaceTo_(value);
	}
}