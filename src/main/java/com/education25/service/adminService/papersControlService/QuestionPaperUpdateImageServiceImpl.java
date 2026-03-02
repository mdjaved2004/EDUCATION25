package com.education25.service.adminService.papersControlService;

import javax.servlet.http.Part;
import com.education25.dao.adminDao.papersControlDao.QuestionPaperUpdateImageDaoImpl;

public class QuestionPaperUpdateImageServiceImpl implements QuestionPaperUpdateImageService {

	@Override
	public String[] updateImageImageService(String paper_name, String paper_id, Part image_input, String contextPath,  int AdminId) {
		return new QuestionPaperUpdateImageDaoImpl().updateImageImageDao(paper_name, paper_id, image_input, contextPath, AdminId);
	}
}