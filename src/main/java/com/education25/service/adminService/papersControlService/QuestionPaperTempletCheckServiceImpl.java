package com.education25.service.adminService.papersControlService;

import com.education25.dao.adminDao.papersControlDao.QuestionPaperTempletCheckDaoImpl;
import com.education25.model.adminModel.paperControlModel.QuestionPaperTempletCheckModel;
import com.education25.validation.checkValues.ChechAZ_az_09_spaceAndFirstcharIsAlphabet;

public class QuestionPaperTempletCheckServiceImpl implements QuestionPaperTempletCheckService {

	@Override
	public QuestionPaperTempletCheckModel checkInformationService(QuestionPaperTempletCheckModel quesPaperbasicInfoFormModel) {
		quesPaperbasicInfoFormModel = validationService(quesPaperbasicInfoFormModel);
		if(quesPaperbasicInfoFormModel.getMessage_error()!=null) {
			return quesPaperbasicInfoFormModel;
		}else {			
			return new QuestionPaperTempletCheckDaoImpl().checkInformationDao(quesPaperbasicInfoFormModel);
		}
	}

	@Override
	public QuestionPaperTempletCheckModel validationService(QuestionPaperTempletCheckModel quesPaperbasicInfoFormModel) {
		String paper_name=null, message_error=null;	
		int total_ques=0, select_que=0, select_marks=0, notSelect_que=0, notSelect_marks=0, total_marks=0;
		
		paper_name= quesPaperbasicInfoFormModel.getPaper_name();
		
		total_ques= Integer.parseInt(quesPaperbasicInfoFormModel.getTotal_ques());
		select_que= Integer.parseInt(quesPaperbasicInfoFormModel.getSelect_que());
		select_marks= Integer.parseInt(quesPaperbasicInfoFormModel.getSelect_marks());
		notSelect_que= Integer.parseInt(quesPaperbasicInfoFormModel.getNotSelect_que());
		notSelect_marks= Integer.parseInt(quesPaperbasicInfoFormModel.getNotSelect_marks());
		total_marks= Integer.parseInt(quesPaperbasicInfoFormModel.getTotal_marks());
		
		
		if(paper_name.trim()==null) {
			message_error = "Paper name is empty, try again and accept numbers paper name only allow  A-Z, 0-9 and space.";
		}else if(!(new ChechAZ_az_09_spaceAndFirstcharIsAlphabet().chechAZ_az_09_spaceAndFirstcharIsAlphabetBollean(paper_name))) {
			message_error = "First character must be a letter. Remaining characters can be letters, numbers, and spaces.";
		}else if(paper_name.length()>30) {
			message_error = "Your putting Paper name out of limits.Enter Paper name under 30 charecter";
		}else if((select_que+notSelect_que)>151){
			message_error = "Your putting total question out of limits.Enter total question  under 151 ";
		}else if(select_marks>11) {
			message_error = "Your putting marks out of limits. Enter marks under 11";
		}else if(notSelect_marks>11){
			message_error = "Your putting marks out of limits. Enter marks under 11";
		}else if((select_que+notSelect_que)!=total_ques) {
			message_error = "You are enter wrong Total Question";
		}else if(((select_que*select_marks)+(notSelect_que*notSelect_marks))!=total_marks) {
			message_error = "You are enter Wrong total marks";
		}		
		if(message_error!=null) {
			quesPaperbasicInfoFormModel.setMessage_error(message_error);
		}		
		return quesPaperbasicInfoFormModel;
	}
}