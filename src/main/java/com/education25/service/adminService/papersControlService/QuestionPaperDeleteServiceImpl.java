package com.education25.service.adminService.papersControlService;

import com.education25.dao.adminDao.papersControlDao.QuestionPaperDeleteDao;
import com.education25.dao.adminDao.papersControlDao.QuestionPaperDeleteDaoImpl;

public class QuestionPaperDeleteServiceImpl implements QuestionPaperDeleteService {
	@Override
	public String deletePaperService(String Paper_name, int adminId) {
		QuestionPaperDeleteDao daoForDeletePaper= new QuestionPaperDeleteDaoImpl();
		
		return daoForDeletePaper.deletePaperService(Paper_name, adminId);
		
	}
}