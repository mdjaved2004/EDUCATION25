package com.education25.service.adminService.papersControlService;

import com.education25.dao.adminDao.papersControlDao.QuestionPaperDeleteOneQuetionDaoImpl;

public class QuestionPaperDeleteOneQuetionServiceImpl implements QuestionPaperDeleteOneQuetionService {

	@Override
	public String deleteOneQuestionService(String paper_name, String questionNo) {
		
		return new QuestionPaperDeleteOneQuetionDaoImpl().deleteOneQuestionDao(paper_name, questionNo);
	}
}