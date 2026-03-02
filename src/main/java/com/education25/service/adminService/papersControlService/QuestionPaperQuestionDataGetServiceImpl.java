package com.education25.service.adminService.papersControlService;

import com.education25.dao.adminDao.papersControlDao.QuestionPaperQuestionDataGetDaoImpl;
import com.education25.model.adminModel.paperControlModel.QuetionPaperFullInformationWithMessageErrorModel;

public class QuestionPaperQuestionDataGetServiceImpl implements QuestionPaperQuestionDataGetService {

	@Override
	public QuetionPaperFullInformationWithMessageErrorModel getInforService(String paper_name) {		
		return new QuestionPaperQuestionDataGetDaoImpl().getInforDao(paper_name);		
	}
}
