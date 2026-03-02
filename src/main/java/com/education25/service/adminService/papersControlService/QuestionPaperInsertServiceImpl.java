package com.education25.service.adminService.papersControlService;

import java.util.ArrayList;
import java.util.List;
import com.education25.dao.adminDao.papersControlDao.QuestionPaperInsertDao;
import com.education25.dao.adminDao.papersControlDao.QuestionPaperInsertDaoImpl;
import com.education25.model.adminModel.paperControlModel.QuestionInformationWithMessageErrorModel;
import com.education25.model.adminModel.paperControlModel.QuestionPaperQuestionDataModel;
import com.education25.model.adminModel.paperControlModel.QuestionPaperTempletCheckModel;
import com.education25.validation.checkValues.CheckStringLengthDynamicaly;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceUnwantedCharecters;

public class QuestionPaperInsertServiceImpl implements QuestionPaperInsertService {

	@Override
	public QuestionInformationWithMessageErrorModel questionPaperInsertService(QuestionPaperTempletCheckModel quesPaperbasicInfoFormModel,
			List<QuestionPaperQuestionDataModel> questionDataStrore, int adminId) {
		String message_error=null;
		
		QuestionInformationWithMessageErrorModel validationQuestionInfo = validationService(questionDataStrore);
		
		//Check any error , if error then return.
		if(validationQuestionInfo.getMessage_error()!=null) {
			return new QuestionInformationWithMessageErrorModel(questionDataStrore, validationQuestionInfo.getMessage_error());
		}else {
			QuestionPaperInsertDao  daoForInserdataInDataBase= new QuestionPaperInsertDaoImpl();
			message_error=daoForInserdataInDataBase.questionPaperInsertDao(quesPaperbasicInfoFormModel, validationQuestionInfo.getQuestionDataStrore(), adminId);		
				
			return new QuestionInformationWithMessageErrorModel(questionDataStrore, message_error);
		}
	}

	@Override
	public QuestionInformationWithMessageErrorModel validationService(List<QuestionPaperQuestionDataModel> questionDataStrore) {
		String message_error = null, message_error_small_part="";
		
		for(QuestionPaperQuestionDataModel quetionInfo: questionDataStrore) {
				int question_no = quetionInfo.getQuestion_no();
			 	String question = quetionInfo.getQuestion();
		        String option_a = quetionInfo.getOption_a();
		        String option_b = quetionInfo.getOption_b();
		        String option_c = quetionInfo.getOption_c();
		        String option_d = quetionInfo.getOption_d();
		        String answer = quetionInfo.getAnswer();
		        
		        if(question==null || question.trim().isEmpty()) {
		        		message_error_small_part = " Question Not allow to empty.";
		        }
		        if(option_a==null || option_a.trim().isEmpty()) {
		        		message_error_small_part = message_error_small_part+ " Option a Not allow to empty.";
		        }
		        if(option_b==null || option_b.trim().isEmpty()) {
		        		message_error_small_part = message_error_small_part+ " Option b Not allow to empty.";
		        }
		        if(option_c==null || option_c.trim().isEmpty()) {
		        		message_error_small_part = message_error_small_part+ " Option c Not allow to empty.";
		        }
		        if(option_d==null || option_d.trim().isEmpty()) {
		        		message_error_small_part = message_error_small_part+ " Option d Not allow to empty.";
		        }
		        if(answer==null || !(answer.equals("a") || answer.equals("b") || answer.equals("c") || answer.equals("d"))) {
		        		message_error_small_part = message_error_small_part+ " Answer Not allow to empty and only use a, b, c and d";
		        }
		        if(!(message_error_small_part.isEmpty())) {
		        		if(message_error!=null) {
		        			message_error =message_error+ " Question "+ question_no +" ->"+message_error_small_part;
		        		}else {
		        			message_error ="Question "+ question_no +" ->"+message_error_small_part;
		        		}     		
		        		message_error_small_part="";
		        }
		}
		
		if(message_error!=null) {
			return new QuestionInformationWithMessageErrorModel(questionDataStrore, message_error);
		}else {
			return replaceUnWantedCharectersService(questionDataStrore);
		}
	}

	public QuestionInformationWithMessageErrorModel replaceUnWantedCharectersService(List<QuestionPaperQuestionDataModel> questionDataStrore) {
		String message_error = null;
		List<QuestionPaperQuestionDataModel> questionDataFilter =new ArrayList<QuestionPaperQuestionDataModel>();
		
		CheckStringLengthDynamicaly checkDynamicLength = new CheckStringLengthDynamicaly();
		ReplaceUnwantedCharecters replaceUnwantedCharecters = new ReplaceUnwantedCharecters();
		
		try {
			for(QuestionPaperQuestionDataModel quetionInfo: questionDataStrore) {
					int question_no = quetionInfo.getQuestion_no();
				 	String question = quetionInfo.getQuestion();
			        String option_a = quetionInfo.getOption_a();
			        String option_b = quetionInfo.getOption_b();
			        String option_c = quetionInfo.getOption_c();
			        String option_d = quetionInfo.getOption_d();
			        String answer = quetionInfo.getAnswer();
			        
			        question = checkDynamicLength.lengthString(replaceUnwantedCharecters.replace(question.trim()), 500);
			        option_a = checkDynamicLength.lengthString(replaceUnwantedCharecters.replace(option_a.trim()), 200);
			        option_b = checkDynamicLength.lengthString(replaceUnwantedCharecters.replace(option_b.trim()), 200);
			        option_c = checkDynamicLength.lengthString(replaceUnwantedCharecters.replace(option_c.trim()), 200);
			        option_d = checkDynamicLength.lengthString(replaceUnwantedCharecters.replace(option_d.trim()), 200);
			        answer = checkDynamicLength.lengthString(answer.trim(), 1);
			        
			        questionDataFilter.add(new QuestionPaperQuestionDataModel(question_no, question, option_a, option_b, option_c, option_d, answer));
			}
		} catch (Exception e) {
			message_error ="Data Filtering Failed, try agein";
			e.printStackTrace();
		}
		
		if(message_error!=null) {
			return new QuestionInformationWithMessageErrorModel(questionDataStrore, message_error);
		}else {
			return new QuestionInformationWithMessageErrorModel(questionDataFilter, message_error);
		}
	}
}