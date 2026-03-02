package com.education25.service.adminService.papersControlService;

import javax.servlet.http.Part;

public interface QuestionPaperUpdateImageService {
	String[] updateImageImageService(String paper_name, String paper_id, Part image_input, String contextPath,  int AdminId);
}