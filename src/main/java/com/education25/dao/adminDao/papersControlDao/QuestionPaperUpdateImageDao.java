package com.education25.dao.adminDao.papersControlDao;

import javax.servlet.http.Part;

public interface QuestionPaperUpdateImageDao {
	String[] updateImageImageDao(String paper_name, String paper_id, Part image_input, String contextPath, int AdminId);
}