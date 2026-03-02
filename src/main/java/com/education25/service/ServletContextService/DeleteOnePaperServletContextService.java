package com.education25.service.ServletContextService;

import javax.servlet.http.HttpServletRequest;

public interface DeleteOnePaperServletContextService {
	boolean deleteOnePaper(HttpServletRequest request, String paper_name);
}
