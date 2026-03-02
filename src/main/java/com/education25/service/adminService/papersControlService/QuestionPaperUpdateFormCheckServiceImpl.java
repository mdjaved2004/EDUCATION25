package com.education25.service.adminService.papersControlService;

import com.education25.dao.adminDao.papersControlDao.QuestionPaperUpdateFormCheckDao;
import com.education25.dao.adminDao.papersControlDao.QuestionPaperUpdateFormCheckDaoImpl;
import com.education25.validation.checkValues.ChechAZ_az_09_spaceAndFirstcharIsAlphabet;

public class QuestionPaperUpdateFormCheckServiceImpl implements QuestionPaperUpdateFormCheckService {

	@Override
	public String checkPaperNameExistService(int admin_id, String paper_name) {
		String message_error=null;
		message_error = checkValidation(paper_name);
		if(message_error!=null) {
			return message_error;
		}
		else {
			QuestionPaperUpdateFormCheckDao questionPapergetInfoDao=new QuestionPaperUpdateFormCheckDaoImpl();
			return questionPapergetInfoDao.CheckAndGetInformationDao(admin_id, paper_name);	
		}
	}

	@Override
	public String checkValidation(String paper_name) {
		String message_error=null;
		
		boolean result = new ChechAZ_az_09_spaceAndFirstcharIsAlphabet().chechAZ_az_09_spaceAndFirstcharIsAlphabetBollean(paper_name);
		
		if(!result) {
			message_error="Papper name only Allow Charecter A to Z, a to z, space and digit allow 0 to 9";
		}
		return message_error;
	}
}