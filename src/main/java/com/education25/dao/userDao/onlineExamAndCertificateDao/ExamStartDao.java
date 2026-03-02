package com.education25.dao.userDao.onlineExamAndCertificateDao;

import java.sql.Connection;
import com.education25.model.userModel.onlineExamAndCertificateModel.ExamStartModel;
import com.education25.model.userModel.onlineExamAndCertificateModel.ExamStartPaperInformation;

public interface ExamStartDao {
	ExamStartModel getExamStartContextDao(String paperName, int paperId);
	
	ExamStartPaperInformation getPaperInformationDao(Connection con, String paperName, int paperId);
}