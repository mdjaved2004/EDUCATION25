package com.education25.dao.adminDao.papersControlDao;

import com.education25.model.adminModel.paperControlModel.QuestionPaperQuestionDataModel;

public interface QuestionPaperUpdateQuestionDao {
	String updateQuestionDao(QuestionPaperQuestionDataModel questionInformationModel, String paper_name);
}