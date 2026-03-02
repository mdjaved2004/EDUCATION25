package com.education25.service.ServletContextService;

import javax.servlet.http.HttpServletRequest;

public interface QuestionPaperUpdateImageLinkServletContextService {
	boolean updateLink(HttpServletRequest request, int paper_id, String paper_name, String image_link);
}