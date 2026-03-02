package com.education25.dao.adminDao.papersControlDao;

import java.util.List;
import com.education25.model.adminModel.paperControlModel.QuestionPaperQuestionDataModel;
import com.education25.model.adminModel.paperControlModel.QuestionPaperTempletCheckModel;

public interface QuestionPaperInsertDao {
	String questionPaperInsertDao(QuestionPaperTempletCheckModel quesPaperbasicInfoFormModel, List<QuestionPaperQuestionDataModel> questionDataStrore, int adminId);
	
}