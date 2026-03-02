package com.education25.service.adminService.papersControlService;

import com.education25.dao.adminDao.papersControlDao.QuestionPaperUpdateFormDao;
import com.education25.dao.adminDao.papersControlDao.QuestionPaperUpdateFormDaoImpl;
import com.education25.model.adminModel.paperControlModel.QuestionPaperUpdateFormDataGetModel;

public class QuestionPaperUpdateFormServiceImpl implements QuestionPaperUpdateFormService {

	@Override
	public QuestionPaperUpdateFormDataGetModel getPaperNameBasedOnAdminService(int adminId) {
		
		QuestionPaperUpdateFormDao getPaperNameDao=new QuestionPaperUpdateFormDaoImpl();
		
		return getPaperNameDao.getPaperNameBasedOnAdminDao(adminId);
	}
}