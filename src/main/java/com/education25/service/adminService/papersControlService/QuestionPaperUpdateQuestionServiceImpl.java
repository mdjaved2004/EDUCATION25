package com.education25.service.adminService.papersControlService;

import com.education25.dao.adminDao.papersControlDao.QuestionPaperUpdateQuestionDaoImpl;
import com.education25.model.adminModel.paperControlModel.QuestionPaperQuestionDataModel;
import com.education25.model.adminModel.paperControlModel.QuestionPaperQuestionDataWithmessageErrorModel;
import com.education25.validation.checkValues.CheckStringLengthDynamicaly;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceUnwantedCharecters;

public class QuestionPaperUpdateQuestionServiceImpl implements QuestionPaperUpdateQuestionService {

	@Override
	public String updateQuestionService(QuestionPaperQuestionDataModel questionInformationModel, String paper_name) {	
		QuestionPaperQuestionDataWithmessageErrorModel replaceUnWantedCharectersService = replaceUnWantedCharectersService(questionInformationModel);
		if(replaceUnWantedCharectersService.getMessage_error()!=null){
			return replaceUnWantedCharectersService.getMessage_error();
		}
		return new QuestionPaperUpdateQuestionDaoImpl().updateQuestionDao(replaceUnWantedCharectersService.getQuetionInformation(), paper_name);
	}
	
	public QuestionPaperQuestionDataWithmessageErrorModel replaceUnWantedCharectersService(QuestionPaperQuestionDataModel questionDataStore) {
		String message_error = null;
		QuestionPaperQuestionDataModel  quistionInfo=null;
		
		CheckStringLengthDynamicaly checkDynamicLength = new CheckStringLengthDynamicaly();
		ReplaceUnwantedCharecters replaceUnwantedCharecters = new ReplaceUnwantedCharecters();
		
		try {
			int question_no = questionDataStore.getQuestion_no();
		 	String question = questionDataStore.getQuestion();
	        String option_a = questionDataStore.getOption_a();
	        String option_b = questionDataStore.getOption_b();
	        String option_c = questionDataStore.getOption_c();
	        String option_d = questionDataStore.getOption_d();
	        String answer = questionDataStore.getAnswer();
				        
	        question = checkDynamicLength.lengthString(replaceUnwantedCharecters.replace(question.trim()), 500);
	        option_a = checkDynamicLength.lengthString(replaceUnwantedCharecters.replace(option_a.trim()), 200);
	        option_b = checkDynamicLength.lengthString(replaceUnwantedCharecters.replace(option_b.trim()), 200);
	        option_c = checkDynamicLength.lengthString(replaceUnwantedCharecters.replace(option_c.trim()), 200);
	        option_d = checkDynamicLength.lengthString(replaceUnwantedCharecters.replace(option_d.trim()), 200);
	        answer = checkDynamicLength.lengthString(answer.trim(), 1);
				        
	        quistionInfo= new QuestionPaperQuestionDataModel(question_no, question, option_a, option_b, option_c, option_d, answer);
			
		} catch (Exception e) {
			message_error ="Data Filtering Failed, try agein";
			e.printStackTrace();
		}
		
		return new QuestionPaperQuestionDataWithmessageErrorModel(quistionInfo, message_error);
	}
}