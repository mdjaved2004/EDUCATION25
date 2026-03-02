package com.education25.dao.adminDao.papersControlDao;

import com.education25.model.adminModel.paperControlModel.QuestionPaperQuestionDataModel;

public interface QuestionPaperAddOneQuetionDao {
	String addOneQuestionDao(QuestionPaperQuestionDataModel questionInformationModel, String paper_name);
}