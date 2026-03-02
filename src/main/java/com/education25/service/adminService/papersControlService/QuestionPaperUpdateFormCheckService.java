package com.education25.service.adminService.papersControlService;

public interface QuestionPaperUpdateFormCheckService {
	String checkPaperNameExistService(int admin_id, String paper_name);
	String checkValidation(String paper_name);
}