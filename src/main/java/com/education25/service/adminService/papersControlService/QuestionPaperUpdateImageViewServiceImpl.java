package com.education25.service.adminService.papersControlService;

import com.education25.dao.adminDao.papersControlDao.QuestionPaperUpdateImageViewDaoImpl;
import com.education25.model.adminModel.paperControlModel.PaperInformationForImageUpdateModel;

public class QuestionPaperUpdateImageViewServiceImpl implements QuestionPaperUpdateImageViewService{

	@Override
	public PaperInformationForImageUpdateModel getPaperInfoService(String paper_name) {
		return new QuestionPaperUpdateImageViewDaoImpl().getPaperInfoDao(paper_name);
	}
}
